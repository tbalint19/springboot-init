package com.aaa.service;

import com.aaa.model.entity.UserAuthInterface;
import com.aaa.model.entity.Confirmation;
import com.aaa.repository.rdb.AuthEntityConfirmationRepository;
import com.aaa.util.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfirmationService {

    private static final Integer CODE_LENGTH = 25;
    private final TimeService time;
    private final AuthEntityConfirmationRepository repository;

    @Autowired
    public ConfirmationService(TimeService timeService, AuthEntityConfirmationRepository repository) {
        this.time = timeService;
        this.repository = repository;
    }

    public Confirmation create(UserAuthInterface userAuthInterface) {
        Confirmation confirmation = new Confirmation();

        confirmation.setCreatedAt(time.getNow());
        confirmation.setConfirmCode(new RandomString(CODE_LENGTH).nextString());
        confirmation.setUsed(false);
        confirmation.setUserAuthInterface(userAuthInterface);

        return confirmation;
    }

    public void save(Confirmation confirmation) {
        repository.save(confirmation);
    }
}
