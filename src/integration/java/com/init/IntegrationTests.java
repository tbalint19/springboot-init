package com.init;

import com.init.service.TimeService;
import com.init.util.UserMockMVC;
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
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
public class IntegrationTests {

    private UserMockMVC user;

    @Autowired private TimeService time; // will use mock because of ActiveProfile - test

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
        // repo.deleteAll()
    }

    @Test
    public void simpleSignupNoDomainRoleNoGroupNoPassword() throws JSONException {
        // given

        // when

        // then
    }
}
