package com.aaa.model.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class AuthEntityConfirmation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private String confirmCode;
    private Boolean used;

    @ManyToOne
    private AuthEntity authEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getConfirmCode() {
        return confirmCode;
    }

    public void setConfirmCode(String confirmCode) {
        this.confirmCode = confirmCode;
    }

    public Boolean getUsed() {
        return used;
    }

    public void setUsed(Boolean used) {
        this.used = used;
    }

    public AuthEntity getAuthEntity() {
        return authEntity;
    }

    public void setAuthEntity(AuthEntity authEntity) {
        this.authEntity = authEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthEntityConfirmation that = (AuthEntityConfirmation) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(confirmCode, that.confirmCode) &&
                Objects.equals(used, that.used) &&
                Objects.equals(authEntity, that.authEntity);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, createdAt, confirmCode, used, authEntity);
    }

    @Override
    public String toString() {
        return "AuthEntityConfirmation{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", confirmCode='" + confirmCode + '\'' +
                ", used=" + used +
                ", authEntity=" + authEntity +
                '}';
    }
}
