package com.aaa.service;

import com.aaa.model.entity.UserAuthInterface;
import com.aaa.repository.rdb.UserAuthInterfaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthInterfaceService {

    private UserAuthInterfaceRepository repository;

    @Autowired
    private UserAuthInterfaceService(UserAuthInterfaceRepository repository) {
        this.repository = repository;
    }

    public UserAuthInterface create(
            String email, String password, Boolean isManualConfirm, Boolean manualPasswordSet, Boolean passwordRequired) {
        UserAuthInterface userAuthInterface = new UserAuthInterface();

        userAuthInterface.setEmail(email);
        userAuthInterface.setPassword(manualPasswordSet ? null : password);
        userAuthInterface.setConfirmed(!isManualConfirm);
        userAuthInterface.setPasswordRequired(passwordRequired);
        userAuthInterface.setActive(true);

        return userAuthInterface;
    }

    public void save(UserAuthInterface entity) {
        repository.save(entity);
    }
}
