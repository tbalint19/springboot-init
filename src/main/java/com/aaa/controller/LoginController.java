package com.aaa.controller;

import com.aaa.model.dto.StatusResponse;
import com.aaa.model.dto.TokenResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entity")
public class LoginController {

    @PostMapping("/login")
    public TokenResponse login() {

        return new TokenResponse(null);
    }

    @GetMapping("/logout")
    public StatusResponse logout() {

        return new StatusResponse(true);
    }

    @GetMapping("/confirm/request")
    public StatusResponse requestConfirm(@RequestParam String identifier) {

        return new StatusResponse(true);
    }

    @PostMapping("/confirm/attempt")
    public StatusResponse confirm(/* DTO */) {

        return new StatusResponse(true);
    }

    @GetMapping("/password/reset/request")
    public StatusResponse requestPasswordSet(@RequestParam String identifier) {

        return new StatusResponse(true);
    }

    @PostMapping("/password/reset/attept")
    public StatusResponse setPassword(/* DTO */) {

        return new StatusResponse(true);
    }
}
