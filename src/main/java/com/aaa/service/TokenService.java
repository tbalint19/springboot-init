package com.aaa.service;

import com.aaa.model.entity.Session;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenService {

    private static final String TOKEN_PREFIX = "Bearer ";

    public String createToken(Session session) {
        String token = Jwts.builder()
                        .setClaims(claimsFromSession(session))
                        .setExpiration(noExpiration())
                        .signWith(SignatureAlgorithm.HS512, noSecret())
                        .compact();
        return TOKEN_PREFIX + token;
    }

    public String parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(noSecret())
                .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                .getBody()
                .get("sessionId", Object.class)
                .toString();
    }

    private Map<String, Object> claimsFromSession(Session session) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("sessionId", session.getSessionId());
        claims.put("userId", session.getUserId());
        claims.put("permissions", session.getPermissions());
        return claims;
    }

    private byte[] noSecret() {
        /* The token is only used as a standard data transfer mechanism - credentials are checked server side */
        return "nosecret".getBytes();
    }

    private Date noExpiration() {
        /* Session should expire, and its expiration should be checked - not the token's */
        return new Date(Long.MAX_VALUE);
    }
}
