package com.init.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public class TestHelper {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> T contentOf(ResponseEntity<String> response, Class<T> responseType) {
        String content = response.getBody();
        try {
            return mapper.readValue(content, responseType);
        } catch (IOException e) {
            return null;
        }
    }

    public static Integer statusOf(ResponseEntity<String> response) {
        return response.getStatusCodeValue();
    }
}
