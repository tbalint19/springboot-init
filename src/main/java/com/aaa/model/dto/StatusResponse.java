package com.aaa.model.dto;

import java.io.Serializable;
import java.util.Objects;

public class StatusResponse implements Serializable {

    private Boolean isSuccessful;

    public StatusResponse() {}

    public StatusResponse(Boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
    }

    public Boolean getSuccessful() {
        return isSuccessful;
    }

    public void setSuccessful(Boolean successful) {
        isSuccessful = successful;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusResponse that = (StatusResponse) o;
        return Objects.equals(isSuccessful, that.isSuccessful);
    }

    @Override
    public int hashCode() {

        return Objects.hash(isSuccessful);
    }

    @Override
    public String toString() {
        return "StatusResponse{" +
                "isSuccessful=" + isSuccessful +
                '}';
    }
}
