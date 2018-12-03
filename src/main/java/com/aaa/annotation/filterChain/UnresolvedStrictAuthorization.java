package com.aaa.annotation.filterChain;

import com.aaa.model.entity.Session;
import com.aaa.model.exception.HTTP403;

import java.util.stream.Collectors;

public class UnresolvedStrictAuthorization extends PermissionResolver {

    private Session session;

    UnresolvedStrictAuthorization(Session session) {
        this.session = session;
    }

    public UnresolvedStrictAuthorizationWithDomainPermission domainPermission(String domainPermission) throws HTTP403 {
        if (!session.getPermissions()
                .stream()
                .map(this::cleanse)
                .collect(Collectors.toList())
                .contains(cleanse(domainPermission))) throw new HTTP403("Domain permission missing");
        return new UnresolvedStrictAuthorizationWithDomainPermission(session);
    }
}
