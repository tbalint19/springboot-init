package com.aaa.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class TimeService {

    public LocalDate getNow() {
        return LocalDate.now();
    }
}
