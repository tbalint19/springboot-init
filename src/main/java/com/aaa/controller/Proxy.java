package com.aaa.controller;

import com.aaa.model.proxy.ProxyConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Proxy {

    @Value("${core.api.url}")
    private String coreApiUrl;

    private RestTemplate restTemplate;

    @Autowired
    public Proxy(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping("**")
    public ResponseEntity api(HttpServletRequest request, HttpEntity entity) {
        HttpMethod method = HttpMethod.resolve(request.getMethod());
        String forwardUrl = coreApiUrl + request.getServletPath();

        // TODO - get token from header » authentication » authorization » accounting

        return restTemplate.exchange(forwardUrl, method, entity, String.class);
    }
}
