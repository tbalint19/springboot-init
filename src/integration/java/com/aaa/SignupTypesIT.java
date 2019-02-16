package com.aaa;

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
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
public class SignupTypesIT {

    @Autowired private MockMvc mockMvc;

    private UserMockMVC userMockMVC;

    @Before
    public void setUp() {
        userMockMVC = new UserMockMVC(mockMvc);
    }

    @After
    public void tearDown() {

    }

    @Test
    public void simpleSignupNoDomainRoleNoGroupNoPassword() throws JSONException {
        // given

        // when

        // then
    }
}
