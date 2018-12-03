package com.aaa.annotation;

import com.aaa.annotation.filterChain.AuthEntity;
import com.aaa.model.entity.UserAuthInterface;
import com.aaa.repository.rdb.UserAuthInterfaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JWTUserAuthInterfaceLoader implements JWTUserLoader {

    private UserAuthInterfaceRepository repository;

    @Autowired
    public JWTUserAuthInterfaceLoader(UserAuthInterfaceRepository repository) {
        this.repository = repository;
    }

    public AuthEntity loadUser(Long userAuthInterfaceId) {
        Optional<UserAuthInterface> optionalUserAuthInterface = repository.findById(userAuthInterfaceId);
        return optionalUserAuthInterface.orElse(null);
    }
}
