package com.aaa.service.email;

import com.aaa.model.entity.SendAttempt;
import com.aaa.repository.rdb.SendAttemptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailStatusLogger {

    private SendAttemptRepository repository;

    @Autowired
    public MailStatusLogger(SendAttemptRepository repository) {
        this.repository = repository;
    }

    void reportSuccess(String to, String subject){
        SendAttempt attempt = new SendAttempt();
        attempt.setSuccessful(true);
        attempt.setTarget(to);
        attempt.setSubject(subject);
        repository.save(attempt);
    }

    void reportFailure(String to, String subject){
        SendAttempt attempt = new SendAttempt();
        attempt.setSuccessful(false);
        attempt.setTarget(to);
        attempt.setSubject(subject);
        attempt.setComment("error");
        repository.save(attempt);
    }
}
