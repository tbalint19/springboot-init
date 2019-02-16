package com.aaa.util;

import org.springframework.stereotype.Service;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@Service
public class UserMockMVC extends AbstractMockMVC {

    public UserMockMVC(MockMvc mockMvc) {
        super(mockMvc);
    }

    /*
    public StatusResponse createUser(CreateRequest request, String rolename) throws Exception {
        String newUserAsJson = writeValueAsString(request);
        MvcResult result =
                perform(post("/api/create/" + rolename).content(newUserAsJson).contentType(APPLICATION_JSON))
                        .andReturn();
        String responseAsString = getResultAsString(result);
        return readValue(responseAsString, StatusResponse.class);
    }
    */
}
