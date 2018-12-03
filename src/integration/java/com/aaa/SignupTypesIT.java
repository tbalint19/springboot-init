package com.aaa;

import com.aaa.controller.AdminController;
import com.aaa.model.dto.TokenResponse;
import com.aaa.model.entity.DomainRole;
import com.aaa.model.entity.UserAuthInterface;
import com.aaa.model.param.UserAuthInterfaceCreateParams;
import com.aaa.repository.rdb.*;
import com.aaa.util.AdminMockMVC;
import com.aaa.util.Decoder;
import com.aaa.util.UserMockMVC;
import org.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
public class SignupTypesIT {

    private static final String USERNAME = "abcd";
    private static final String EMAIL = "a@b.cd";
    private static final String PHONE_NUMBER = "+36701234567";
    private static DomainRole USER_ROLE = null;
    private static final String PASSWORD = "12345Abcde";

    @Autowired private MockMvc mockMvc;
    @Autowired private UserAuthInterfaceRepository userAuthInterfaceRepository;
    @Autowired private DomainRoleRepository domainRoleRepository;
    @Autowired private DomainPermissionRepository domainPermissionRepository;
    @Autowired private GroupRoleRepository groupRoleRepository;
    @Autowired private GroupPermissionRepository groupPermissionRepository;
    @Autowired private AdminController adminController;

    private AdminMockMVC adminMockMVC;
    private UserMockMVC userMockMVC;
    private Decoder decoder;

    @Before
    public void setUp() {
        adminMockMVC = new AdminMockMVC(mockMvc);
        userMockMVC = new UserMockMVC(mockMvc);
        decoder = new Decoder();
    }

    @After
    public void tearDown() {
        domainRoleRepository.deleteAll();
        domainPermissionRepository.deleteAll();
        groupRoleRepository.deleteAll();
        groupPermissionRepository.deleteAll();
    }

    @Test
    public void simpleSignupNoDomainRoleNoGroupNoPassword() throws JSONException {
        // given
        UserAuthInterfaceCreateParams params = new UserAuthInterfaceCreateParams.Builder()
                .username(USERNAME)
                .email(EMAIL)
                .rawPassword(PASSWORD)
                .passwordRequired(true)
                .manualConfirm(false)
                .manualPasswordSet(false)
                .build();
        UserAuthInterface userAuthInterface = adminController.createUserAuthInterface(params);

        // when
        TokenResponse response = userMockMVC.login(USERNAME, PASSWORD);

        // then
        String token = response.getToken();
        assertThat(token).isNotNull();
        assertThat(decoder.decodeJWTForField(token, "sessionId")).isNotNull();
        assertThat(decoder.decodeJWTForField(token, "userId")).isEqualTo(userAuthInterface.getId().intValue());
    }
}
