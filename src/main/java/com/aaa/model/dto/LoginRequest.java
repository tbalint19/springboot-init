package com.aaa.model.dto;

import java.util.Objects;

public class LoginRequest {

    private String credential;

    private String password;

    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginRequest that = (LoginRequest) o;
        return Objects.equals(credential, that.credential) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {

        return Objects.hash(credential, password);
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "credential='" + credential + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
