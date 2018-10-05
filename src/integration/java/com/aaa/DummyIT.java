package com.aaa;

import com.aaa.model.HelloDTO;
import com.aaa.util.DummyMockMVC;
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
public class DummyIT {

    @Autowired private MockMvc mockMvc;
    private DummyMockMVC dummyMockMVC;

    @Before
    public void setUp() {
        dummyMockMVC = new DummyMockMVC(mockMvc);
    }

    @Test
    public void dummyTest() {
        // given
        /* Nothing happens */

        // when
        HelloDTO response = dummyMockMVC.dummyRequest();

        // then
        assertThat(response.getGreeting()).isEqualTo("asd");
    }
}
