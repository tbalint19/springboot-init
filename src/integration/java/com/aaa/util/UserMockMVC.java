package com.aaa.util;

import com.aaa.model.dto.LoginRequest;
import com.aaa.model.dto.TokenResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@Service
public class UserMockMVC extends AbstractMockMVC {

    public UserMockMVC(MockMvc mockMvc) {
        super(mockMvc);
    }

    public TokenResponse login(String credential, String password) {
        LoginRequest request = new LoginRequest();
        request.setCredential(credential);
        request.setRawPassword(password);
        String requestBody = writeValueAsString(request);

        MvcResult result = perform(post("/auth/api/entity/login")
                .content(requestBody)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String responseBody = getResultAsString(result);

        return readValue(responseBody, TokenResponse.class);
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
