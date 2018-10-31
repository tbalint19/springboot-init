package com.aaa.model.dto;

import java.io.Serializable;
import java.util.Objects;

public class TokenResponse implements Serializable {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public TokenResponse() {
    }

    public TokenResponse(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TokenResponse that = (TokenResponse) o;
        return Objects.equals(token, that.token);
    }

    @Override
    public int hashCode() {

        return Objects.hash(token);
    }

    @Override
    public String toString() {
        return "TokenResponse{" +
                "token='" + token + '\'' +
                '}';
    }
}
