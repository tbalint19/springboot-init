package com.aaa.util;

import com.aaa.model.HelloDTO;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

public class DummyMockMVC extends AbstractMockMVC {

    public DummyMockMVC(MockMvc mockMvc) {
        super(mockMvc);
    }

    public HelloDTO dummyRequest() {
        MvcResult result = perform(get("/api/authentication/hello")).andReturn();
        return readValue(getResultAsString(result), HelloDTO.class);
    }
}
