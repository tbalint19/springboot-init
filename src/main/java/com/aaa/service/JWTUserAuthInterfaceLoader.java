package com.aaa.service;

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

    public Object loadUser(Long userAuthInerfaceId) {
        Optional<UserAuthInterface> optionalUserAuthInterface = repository.findById(userAuthInerfaceId);
        return optionalUserAuthInterface.orElse(null);
    }
}
