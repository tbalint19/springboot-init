package com.aaa.util;

import com.aaa.controller.AdminController;
import com.aaa.model.dto.StatusResponse;
import com.aaa.model.entity.DomainPermission;
import com.aaa.model.entity.DomainRole;
import com.aaa.model.entity.UserAuthInterface;
import com.aaa.model.param.UserAuthInterfaceCreateParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@Service
public class AdminMockMVC extends AbstractMockMVC {

    private AdminController adminController;

    public AdminMockMVC(MockMvc mockMvc) {
        super(mockMvc);

    }

    //public UserAuthInterface createUserAuthInterface() {
    //    MvcResult result = perform(get("/api/authentication/hello")).andReturn();
    //    return readValue(getResultAsString(result), UserAuthInterface.class);
    //}
}
