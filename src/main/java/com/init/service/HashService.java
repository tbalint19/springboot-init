package com.init.service;

public interface HashService {

    String create(String rawPassword);

    Boolean check(String rawPassword, String hashedPassword);
}
