package com.aaa.annotation.filterChain;

import com.aaa.model.entity.Session;

import java.util.stream.Collectors;

public class UnresolvedLazyAuthorization extends PermissionResolver {

    private Session session;

    UnresolvedLazyAuthorization(Session session) {
        this.session = session;
    }

    public UnresolvedLazyAuthorizationWithDomainPermission domainPermission(String domainPermission) {
        Boolean shouldPass = session.getPermissions()
                .stream()
                .map(this::cleanse)
                .collect(Collectors.toList())
                .contains(cleanse(domainPermission));

        return new UnresolvedLazyAuthorizationWithDomainPermission(session, shouldPass);
    }
}
