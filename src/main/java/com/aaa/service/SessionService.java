package com.aaa.service;

import com.aaa.model.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SessionService {

    private final TimeService timeService;

    @Autowired
    public SessionService(TimeService timeService) {
        this.timeService = timeService;
    }

    public Session createSession(AuthEntity authEntity) {
        Session session = new Session();

        session.setUserId(authEntity.getId());
        session.setCreatedAt(timeService.getNow());
        session.setLastUsedAt(timeService.getNow());
        session.setPermissions(authEntity.getDomainRole().getDomainPermissions()
                .stream().map(DomainPermission::getName).collect(Collectors.toList()));

        List<Session.GroupData> groupDataList = new ArrayList<>();
        for (Membership membership: authEntity.getMemberships()) {
            Session.GroupData groupData = new Session.GroupData();
            groupData.setGroupId(membership.getGroup().getId());
            groupData.setPermissions(membership.getGroupRole().getGroupPermissions()
                    .stream().map(GroupPermission::getName).collect(Collectors.toList()));
            groupDataList.add(groupData);
        }
        session.setGroups(groupDataList);

        return session;
    }
}
