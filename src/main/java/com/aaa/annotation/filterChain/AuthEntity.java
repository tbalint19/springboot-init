package com.aaa.annotation.filterChain;

import com.aaa.model.entity.Session;
import com.aaa.model.exception.HTTP401;
import com.google.common.annotations.VisibleForTesting;

import javax.persistence.Transient;

public abstract class AuthEntity {

    public abstract Long getId();

    @Transient private Session session;

    @VisibleForTesting void setSession(Session session) {
        this.session = session;
    }

    public void exists() throws HTTP401 {
        if (getId() == null) throw new HTTP401("User not found");
    }

    public UnresolvedAuthorization existsWith() throws HTTP401 {
        exists();
        return new UnresolvedAuthorization(session);
    }

}
