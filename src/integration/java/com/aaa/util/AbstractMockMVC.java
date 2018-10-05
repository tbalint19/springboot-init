package com.aaa.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;

import java.io.UnsupportedEncodingException;

public abstract class AbstractMockMVC {

    private final MockMvc mockMvc;
    private final ObjectMapper objectMapper;

    AbstractMockMVC(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
        objectMapper = new ObjectMapper();
    }

    String getContentAsString(MvcResult update) {
        try {
            return update.getResponse().getContentAsString();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    String getResultAsString(MvcResult result) {
        try {
            return result.getResponse().getContentAsString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    <T> T readValue(String content, Class<T> valueType) {
        try {
            return objectMapper.readValue(content, valueType);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    String writeValueAsString(Object value) {
        try {
            return objectMapper.writeValueAsString(value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    ResultActions perform(RequestBuilder requestBuilder) {
        try {
            return mockMvc.perform(requestBuilder);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
