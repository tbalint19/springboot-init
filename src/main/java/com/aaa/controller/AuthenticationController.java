package com.aaa.controller;

import com.aaa.model.HelloDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authentication")
public class AuthenticationController {

    @GetMapping("/hello")
    public HelloDTO hello() {
        HelloDTO dto = new HelloDTO();
        dto.setGreeting("asd");
        return dto;
    }
}
