package com.init.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.SecureRandom;

@Profile("!test")
@Service
public final class RandomServiceImpl implements RandomService {

    private static SecureRandom random = new SecureRandom();

    public String generateRandomString(){
        return new BigInteger(130, random).toString(32);
    }
}
