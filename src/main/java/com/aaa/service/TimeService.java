package com.aaa.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class TimeService {

    public LocalDateTime getNow() {
        return LocalDateTime.now(ZoneId.of("UTC"));
    }

}
