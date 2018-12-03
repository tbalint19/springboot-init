package com.aaa.service;

import com.aaa.model.entity.UserAuthInterface;
import com.aaa.repository.rdb.UserAuthInterfaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAuthInterfaceService {

    private UserAuthInterfaceRepository repository;
    private CredentialInterpreter credentialInterpreter;
    private HashService hash;

    @Autowired
    private UserAuthInterfaceService(
            UserAuthInterfaceRepository repository,
            CredentialInterpreter credentialInterpreter,
            HashService hashService) {
        this.repository = repository;
        this.credentialInterpreter = credentialInterpreter;
        this.hash = hashService;
    }

    public UserAuthInterface create(
            String username,
            String email,
            String phoneNumber,
            String password,
            Boolean isManualConfirm,
            Boolean manualPasswordSet,
            Boolean passwordRequired) {
        UserAuthInterface userAuthInterface = new UserAuthInterface();

        userAuthInterface.setUsername(username);
        userAuthInterface.setEmail(email);
        userAuthInterface.setPassword(manualPasswordSet ? null : password);
        userAuthInterface.setConfirmed(!isManualConfirm);
        userAuthInterface.setPasswordRequired(passwordRequired);
        userAuthInterface.setActive(true);

        return userAuthInterface;
    }

    public UserAuthInterface load(String credential, String password) {
        Optional<UserAuthInterface> optionalUserAuthInterface = find(credential);
        if (!optionalUserAuthInterface.isPresent()) return null;

        UserAuthInterface userAuthInterface = optionalUserAuthInterface.get();
        if (!hash.check(password, userAuthInterface.getPassword())) return null;

        return userAuthInterface;
    }

    private Optional<UserAuthInterface> find(String credential) {
        if (credentialInterpreter.isUsername(credential)) {
            return repository.findByUsername(credential);
        }

        if (credentialInterpreter.isEmail(credential)) {
            return repository.findByUsername(credentialInterpreter.cleanseEmail(credential));
        }

        if (credentialInterpreter.isPhoneNumber(credential)) {
            return repository.findByUsername(credentialInterpreter.cleansePhoneNumber(credential));
        }

        return Optional.empty();
    }

    public void save(UserAuthInterface entity) {
        repository.save(entity);
    }
}
