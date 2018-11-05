package com.aaa.service;

import com.aaa.model.entity.UserAuthInterface;
import com.aaa.model.entity.UserAuthInterfaceConfirmation;
import com.aaa.repository.rdb.UserAuthInterfaceConfirmationRepository;
import com.aaa.util.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfirmationService {

    private static final Integer CODE_LENGTH = 25;
    private final TimeService time;
    private final UserAuthInterfaceConfirmationRepository repository;

    @Autowired
    public ConfirmationService(TimeService timeService, UserAuthInterfaceConfirmationRepository repository) {
        this.time = timeService;
        this.repository = repository;
    }

    public UserAuthInterfaceConfirmation create(UserAuthInterface userAuthInterface) {
        UserAuthInterfaceConfirmation userAuthInterfaceConfirmation = new UserAuthInterfaceConfirmation();

        userAuthInterfaceConfirmation.setCreatedAt(time.getNow());
        userAuthInterfaceConfirmation.setConfirmCode(new RandomString(CODE_LENGTH).nextString());
        userAuthInterfaceConfirmation.setUsed(false);
        userAuthInterfaceConfirmation.setUserAuthInterface(userAuthInterface);

        return userAuthInterfaceConfirmation;
    }

    public void save(UserAuthInterfaceConfirmation userAuthInterfaceConfirmation) {
        repository.save(userAuthInterfaceConfirmation);
    }
}
