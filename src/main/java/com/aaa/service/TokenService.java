package com.aaa.service;

import com.aaa.model.entity.Session;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenService {

    @Autowired
    private TimeService timeService;

    private static final String TOKEN_PREFIX = "Bearer ";
    private static final String SECRET = "secret";

    public String createToken(Session session) {
        Map<String, Object> claims = createClaims(session);
        Date expirationTime = calculateExpirationTime();
        String token = Jwts.builder()
                        .setClaims(claims)
                        .setExpiration(expirationTime)
                        .signWith(SignatureAlgorithm.HS512, SECRET.getBytes())
                        .compact();
        return TOKEN_PREFIX + token;
    }

    public String parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET.getBytes())
                .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                .getBody()
                .get("sessionId", Object.class)
                .toString();
    }

    private Map<String, Object> createClaims(Session session) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("sessionId", session.getSessionId());
        claims.put("userId", session.getUserId());
        claims.put("permissions", session.getPermissions());
        return claims;
    }

    private Date calculateExpirationTime() {
        LocalDate oneDayAway = timeService.getNow().plusDays(1);
        return Date.from(oneDayAway.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
