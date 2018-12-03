package com.aaa.annotation.filterChain;

import com.aaa.model.dto.GroupData;
import com.aaa.model.entity.Session;
import com.aaa.model.exception.HTTP403;

import java.util.ArrayList;
import java.util.List;

public class UnresolvedLazyAuthorizationWithDomainPermission {

    private Session session;
    private Boolean shouldPassBasedOnDomain;

    UnresolvedLazyAuthorizationWithDomainPermission(Session session, Boolean shouldPass) {
        this.session = session;
        this.shouldPassBasedOnDomain = shouldPass;
    }

    public UnresolvedLazyAuthorizationWithDomainAndGroupPermission orGroupPermission(String groupPermission) {
        List<String> permissions = new ArrayList<>();
        for (GroupData groupData: session.getGroups())
            permissions.addAll(groupData.getPermissions());

        Boolean shouldPass = permissions.contains(groupPermission);
        return new UnresolvedLazyAuthorizationWithDomainAndGroupPermission(session, shouldPassBasedOnDomain, shouldPass, groupPermission);
    }
}
