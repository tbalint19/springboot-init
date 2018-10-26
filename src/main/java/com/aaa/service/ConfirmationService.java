package com.aaa.service;

import com.aaa.model.entity.AuthEntity;
import com.aaa.model.entity.AuthEntityConfirmation;
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

    public AuthEntityConfirmation create(AuthEntity authEntity) {
        AuthEntityConfirmation confirmation = new AuthEntityConfirmation();

        confirmation.setCreatedAt(time.getNow());
        confirmation.setConfirmCode(new RandomString(CODE_LENGTH).nextString());
        confirmation.setUsed(false);
        confirmation.setAuthEntity(authEntity);

        return confirmation;
    }

    public void save(AuthEntityConfirmation confirmation) {
        repository.save(confirmation);
    }
}
