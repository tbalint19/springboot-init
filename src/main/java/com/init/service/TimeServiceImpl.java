package com.init.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Profile("!test")
@Service
public class TimeServiceImpl implements TimeService {

    public LocalDateTime getNow() {
        return LocalDateTime.now(ZoneId.of("UTC"));
    }

}
