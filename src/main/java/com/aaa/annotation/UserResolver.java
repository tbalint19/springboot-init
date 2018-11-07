package com.aaa.annotation;

import com.aaa.model.dto.Token;
import com.aaa.service.JWTUserLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;


@Component
public class UserResolver implements HandlerMethodArgumentResolver {

    private JWTUserLoader jwtUserLoader;

    @Autowired
    public UserResolver(JWTUserLoader jwtUserLoader) {
        this.jwtUserLoader = jwtUserLoader;
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
        Token token = (Token) webRequest.getAttribute("parsedJWT", 0);
        if (token == null) return null;
        Long id = token.getUserAuthInterfaceId();
        if (id == null) return null;
        return jwtUserLoader.loadUser(id);
    }
}
