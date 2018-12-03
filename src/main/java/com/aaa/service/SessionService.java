package com.aaa.service;

import com.aaa.annotation.filterChain.AuthEntity;
import com.aaa.model.dto.GroupData;
import com.aaa.model.entity.*;
import com.aaa.repository.redis.SessionRepository;
import com.aaa.util.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SessionService {

    private final TimeService timeService;
    private final HashService hash;
    private final SessionRepository repository;

    @Autowired
    public SessionService(TimeService timeService, HashService hashService, SessionRepository repository) {
        this.timeService = timeService;
        this.hash = hashService;
        this.repository = repository;
    }

    public Session createSession(UserAuthInterface userAuthInterface) {
        Session session = new Session();

        session.setUserAuthInterfaceId(userAuthInterface.getId());
        session.setCreatedAt(timeService.getNow());
        session.setLastUsedAt(timeService.getNow());
        if (userAuthInterface.getDomainRole() != null)
            session.setPermissions(userAuthInterface.getDomainRole().getDomainPermissions()
                    .stream().map(DomainPermission::getName).collect(Collectors.toList()));
        else
            session.setPermissions(new ArrayList<>());

        List<GroupData> groupDataList = new ArrayList<>();
        for (Membership membership: userAuthInterface.getMemberships()) {
            GroupData groupData = new GroupData();
            groupData.setGroupId(membership.getGroupAuthInterface().getId());
            groupData.setPermissions(membership.getGroupRole().getGroupPermissions()
                    .stream().map(GroupPermission::getName).collect(Collectors.toList()));
            groupDataList.add(groupData);
        }
        session.setGroups(groupDataList);

        session.setSessionId(generateSessionId(userAuthInterface));

        return session;
    }

    public void saveSession(Session session) {
        repository.save(session);
    }

    public void deleteSession(Session session) {}

    public void deleteSessions(AuthEntity user) {

    }

    public Session loadSession(String sessionId) {
        Optional<Session> sessionOptional = repository.findBySessionId(sessionId);
        if (!sessionOptional.isPresent())
            return null;
        Session session = sessionOptional.get();

        if (session.getLastUsedAt().plusMinutes(5).isBefore(timeService.getNow()))
            return null;

        if (session.getCreatedAt().plusHours(8).isBefore(timeService.getNow()))
            return null;

        return session;
    }

    private String generateSessionId(UserAuthInterface userAuthInterface) {
        return new RandomString(32).nextString() + hash.create(userAuthInterface.getId().toString());
    }
}
