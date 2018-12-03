package com.aaa.annotation.filterChain;

import com.aaa.annotation.JWTUserLoader;
import com.aaa.annotation.UnAuthenticatedUser;
import com.aaa.annotation.User;
import com.aaa.model.entity.Session;
import com.aaa.service.SessionService;
import com.aaa.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.validation.constraints.NotNull;


@Component
public class UserResolver implements HandlerMethodArgumentResolver {

    private static final String AUTH_HEADER = "Authorization";
    private JWTUserLoader jwtUserLoader;
    private TokenService tokenService;
    private SessionService sessionService;

    @Autowired
    public UserResolver(JWTUserLoader jwtUserLoader, TokenService tokenService, SessionService sessionService) {
        this.jwtUserLoader = jwtUserLoader;
        this.tokenService = tokenService;
        this.sessionService = sessionService;
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(User.class) != null;
    }

    @Override
    public Object resolveArgument(
            MethodParameter parameter,
            ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest,
            WebDataBinderFactory binderFactory) throws Exception {
        String jwt = webRequest.getHeader(AUTH_HEADER);
        if (jwt == null) return new UnAuthenticatedUser();

        String sessionId = tokenService.parseToken(jwt);
        if (sessionId == null) return new UnAuthenticatedUser();

        Session session = sessionService.loadSession(sessionId);
        if (session == null) return new UnAuthenticatedUser();

        Long userAuthInterfaceId = session.getUserAuthInterfaceId();
        if (!parameter.getParameterAnnotation(User.class).load()) return new UnloadedUser(userAuthInterfaceId);

        AuthEntity authEntity = jwtUserLoader.loadUser(userAuthInterfaceId);
        if (authEntity == null) return new UnAuthenticatedUser();

        authEntity.setSession(session);
        return authEntity;
    }
}
