package com.aaa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        /* No protection is needed, only available behind VPN, for the auth layer */
        httpSecurity.csrf().disable().authorizeRequests().antMatchers("**").permitAll();
    }
}
