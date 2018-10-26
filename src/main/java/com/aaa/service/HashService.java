package com.aaa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class HashService {

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public HashService(BCryptPasswordEncoder encoder) {
        this.bCryptPasswordEncoder = encoder;
    }

    public String create(String rawPassword) {
        if (rawPassword == null) return null;
        return bCryptPasswordEncoder.encode(rawPassword);
    }

    public Boolean check(String rawPassword, String hashedPassword) {
        if (hashedPassword == null) return false;
        return bCryptPasswordEncoder.matches(rawPassword, hashedPassword);
    }
}
