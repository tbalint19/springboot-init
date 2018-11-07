package com.aaa.interceptor;

import com.aaa.model.dto.Token;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JWTParserInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String jwt = request.getHeader("Authentication");

        // TODO - parse jwt and  create a parsed token with all the validated data

        Token token = new Token();
        request.setAttribute("parsedJWT", token);
        return true;
    }
}
