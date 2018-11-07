package com.aaa.service;

import com.aaa.model.entity.PasswordReset;
import com.aaa.model.entity.UserAuthInterface;
import com.aaa.repository.rdb.PasswordResetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasswordResetService {

    private PasswordResetRepository repository;

    @Autowired
    public PasswordResetService(PasswordResetRepository repository) {
        this.repository = repository;
    }

    public PasswordReset create(UserAuthInterface userAuthInterface) {
        PasswordReset passwordReset = new PasswordReset();

        return passwordReset;
    }

    public void save(PasswordReset reset) {
        repository.save(reset);
    }
}
