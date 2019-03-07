package com.init.dummy;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class DummyTests {


    public void shouldRun() {
        // given


        // when
        Long x = 1L;

        // then
        assertThat(x).isEqualTo(1L);
    }

}
