package com.aaa.annotation.filterChain;

import java.util.Objects;

public class UnloadedUser extends AuthEntity {

    private Long id;

    @Override
    public Long getId() {
        return null;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UnloadedUser(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnloadedUser that = (UnloadedUser) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "UnloadedUser{" +
                "id=" + id +
                '}';
    }
}
