package com.aaa.model.dto;

import java.util.Objects;

public class DefaultHttpAuthError {

    private String message;

    public DefaultHttpAuthError() {
    }

    public DefaultHttpAuthError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultHttpAuthError that = (DefaultHttpAuthError) o;
        return Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {

        return Objects.hash(message);
    }

    @Override
    public String toString() {
        return "DefaultHttpAuthError{" +
                "message='" + message + '\'' +
                '}';
    }
}
