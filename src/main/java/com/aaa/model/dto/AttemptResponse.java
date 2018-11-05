package com.aaa.model.dto;

import java.util.Objects;

public class AttemptResponse {

    private Boolean attempted;

    public AttemptResponse() {
    }

    public AttemptResponse(Boolean attempted) {
        this.attempted = attempted;
    }

    public Boolean getAttempted() {
        return attempted;
    }

    public void setAttempted(Boolean attempted) {
        this.attempted = attempted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttemptResponse that = (AttemptResponse) o;
        return Objects.equals(attempted, that.attempted);
    }

    @Override
    public int hashCode() {

        return Objects.hash(attempted);
    }

    @Override
    public String toString() {
        return "AttemptResponse{" +
                "attempted=" + attempted +
                '}';
    }
}
