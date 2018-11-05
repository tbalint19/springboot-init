package com.aaa.service;

import com.aaa.model.entity.UserAuthInterface;
import com.aaa.repository.rdb.UserAuthInterfaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthEntityService {

    private UserAuthInterfaceRepository repository;

    @Autowired
    private AuthEntityService(UserAuthInterfaceRepository repository) {
        this.repository = repository;
    }

    public void save(UserAuthInterface entity) {
        repository.save(entity);
    }
}
