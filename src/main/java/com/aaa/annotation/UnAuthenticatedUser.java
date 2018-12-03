package com.aaa.annotation;

import com.aaa.annotation.filterChain.AuthEntity;

public class UnAuthenticatedUser extends AuthEntity {
    @Override
    public Long getId() {
        return null;
    }
}
