package com.aaa.service;

import com.aaa.model.entity.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SessionService {

    public Session createSession(AuthEntity authEntity) {
        Session session = new Session();

        session.setUserId(authEntity.getId());
        session.setCreatedAt(LocalDateTime.now());
        session.setLastUsedAt(LocalDateTime.now());
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
