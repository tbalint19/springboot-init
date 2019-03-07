package com.init.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
//@Profile("dev")
public class SimpleCorsFilter implements Filter {

    @Value("${cors.frontend.url:http://localhost:8080}")
    private String sourceUrl;

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;
        response.setHeader("Access-Control-Allow-Origin", sourceUrl);
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader(
                "Access-Control-Allow-Headers",
                "Origin," +
                        "Accept,X-Requested-With," +
                        "Content-Type," +
                        "Access-Control-Request-Method," +
                        "Access-Control-Request-Headers," +
                        "Authorization"
        );
        if (request.getMethod().equals(HttpMethod.OPTIONS.name())) {
            response.setStatus(HttpStatus.NO_CONTENT.value());
        } else {
            chain.doFilter(req, res);
        }
    }

    public void init(FilterConfig filterConfig) {
    }

    public void destroy() {
    }
}
