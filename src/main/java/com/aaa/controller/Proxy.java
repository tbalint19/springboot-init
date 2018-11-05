package com.aaa.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller("/api")
public class Proxy {

    @Value("${api.prefix.secure:/secure}")
    private String securePrefix;

    @RequestMapping("/**")
    public String api(HttpServletRequest request) {
        String forwardUrl = securePrefix + request.getServletPath();

        // TODO - get token from header » authentication » authorization » accounting

        return "forward:/" + forwardUrl;
    }

}
