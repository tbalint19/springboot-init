package com.aaa.config;

import com.aaa.annotation.JWTResolver;
import com.aaa.annotation.UserResolver;
import com.aaa.interceptor.JWTParserInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired private JWTResolver jwtResolver;
    @Autowired private UserResolver userResolver;

    @Override
    public void addInterceptors (InterceptorRegistry registry) {
        registry.addInterceptor(new JWTParserInterceptor());
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(jwtResolver);
        argumentResolvers.add(userResolver);
    }
}
