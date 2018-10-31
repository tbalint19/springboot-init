package com.aaa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Proxy {

    private static final String SECURE_PREFIX = "/secure";

    @RequestMapping("**")
    public String api(HttpServletRequest request) {
        String forwardUrl = SECURE_PREFIX + request.getServletPath();

        // TODO - get token from header » authentication » authorization » accounting
        System.out.println("Forward comes now...");

        return "forward:/" + forwardUrl;
    }

}
