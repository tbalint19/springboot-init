package com.aaa.controller;

import com.aaa.annotation.User;
import com.aaa.annotation.filterChain.AuthEntity;
import com.aaa.model.dto.LoginRequest;
import com.aaa.model.dto.StatusResponse;
import com.aaa.model.dto.TokenResponse;
import com.aaa.model.entity.Session;
import com.aaa.model.entity.UserAuthInterface;
import com.aaa.model.exception.HTTP401;
import com.aaa.service.SessionService;
import com.aaa.service.TokenService;
import com.aaa.service.UserAuthInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/api/entity")
public class LoginController {

    private UserAuthInterfaceService userAuthInterfaceService;
    private SessionService sessionService;
    private TokenService tokenService;

    @Autowired
    public LoginController(
            UserAuthInterfaceService userAuthInterfaceService,
            SessionService sessionService,
            TokenService tokenService) {
        this.userAuthInterfaceService = userAuthInterfaceService;
        this.sessionService = sessionService;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public TokenResponse loginSimple(@RequestBody LoginRequest request) {
        String credential = request.getCredential();
        String password = request.getPassword();

        UserAuthInterface userAuthInterface = userAuthInterfaceService.load(credential, password);
        if (userAuthInterface == null) return new TokenResponse(null);

        Session session = sessionService.createSession(userAuthInterface);
        sessionService.saveSession(session);

        String token = tokenService.createToken(session);
        return new TokenResponse(token);
    }

    @PostMapping("/login/twofactor")
    public TokenResponse loginTwoFactor(@RequestBody LoginRequest request) {
        TokenResponse response = loginSimple(request);

        // SMS

        return response;
    }

    @PostMapping("/login/twofactor/confirm")
    public TokenResponse loginTwoFactorConfirm(@RequestBody LoginRequest request) {

        // SMS

        return new TokenResponse(null);
    }

    @GetMapping("/logout/device")
    public StatusResponse logoutDevice(@User AuthEntity user) {
        
        return new StatusResponse(true);
    }

    @GetMapping("/logout/user")
    public StatusResponse logoutUser(@User AuthEntity user) throws HTTP401 {
        user.exists();

        sessionService.deleteSessions(user);

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

    @PostMapping("/password/reset/attempt")
    public StatusResponse setPassword(/* DTO */) {

        return new StatusResponse(true);
    }
}
