package com.aaa.annotation.filterChain;

import com.aaa.model.entity.Session;
import com.aaa.model.exception.HTTP403;

import java.util.stream.Collectors;

public class UnresolvedAuthorization extends PermissionResolver {

    private Session session;

    UnresolvedAuthorization(Session session) {
        this.session = session;
    }

    public void domainPermission(String domainPermission) throws HTTP403 {
        if (!session.getPermissions()
                .stream()
                .map(this::cleanse)
                .collect(Collectors.toList())
                .contains(cleanse(domainPermission))) throw new HTTP403("Domain permission missing");
    }

    public UnresolvedStrictAuthorization both() {
        return new UnresolvedStrictAuthorization(session);
    }

    public UnresolvedLazyAuthorization either() {
        return new UnresolvedLazyAuthorization(session);
    }
}
