package com.aaa.annotation;

import com.aaa.annotation.filterChain.AuthEntity;

public interface JWTUserLoader {

    AuthEntity loadUser(Long userAuthInterfaceId);
}
