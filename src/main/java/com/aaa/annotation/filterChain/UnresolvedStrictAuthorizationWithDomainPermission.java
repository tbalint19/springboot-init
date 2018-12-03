package com.aaa.annotation.filterChain;

import com.aaa.model.dto.GroupData;
import com.aaa.model.entity.Session;
import com.aaa.model.exception.HTTP403;

import java.util.ArrayList;
import java.util.List;

public class UnresolvedStrictAuthorizationWithDomainPermission extends PermissionResolver {

    private Session session;

    UnresolvedStrictAuthorizationWithDomainPermission(Session session) {
        this.session = session;
    }

    public UnresolvedStrictAuthorizationWithDomainAndGroupPermission andGroupPermission(String groupPermission) throws HTTP403 {
        List<String> permissions = new ArrayList<>();
        for (GroupData groupData: session.getGroups())
            permissions.addAll(groupData.getPermissions());

        if (!permissions.contains(groupPermission)) throw new HTTP403("Group permission missing");

        return new UnresolvedStrictAuthorizationWithDomainAndGroupPermission(session, groupPermission);
    }
}
