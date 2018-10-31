package com.aaa.service;

import com.aaa.model.entity.UserAuthInterface;
import com.aaa.repository.rdb.AuthEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthEntityService {

    private AuthEntityRepository repository;

    @Autowired
    private AuthEntityService(AuthEntityRepository repository) {
        this.repository = repository;
    }

    public void save(UserAuthInterface entity) {
        repository.save(entity);
    }
}
