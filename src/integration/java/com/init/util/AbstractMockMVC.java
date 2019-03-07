package com.init.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;

import java.io.UnsupportedEncodingException;

public abstract class AbstractMockMVC {

    @Autowired
    TestRestTemplate testRestTemplate;

    public ResponseEntity<String> get(String path) {
        return this.testRestTemplate.getForEntity(path, String.class);
    }

    public ResponseEntity<String> post(String path, Object data) {
        return this.testRestTemplate.postForEntity(path, data, String.class);
    }
}
