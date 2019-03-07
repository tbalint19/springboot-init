package com.init.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Profile("!test")
@Service
public class HashServiceImpl implements HashService {

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public HashServiceImpl(BCryptPasswordEncoder encoder) {
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
