package com.aaa.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class PasswordReset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdAt;
    private String resetCode;
    private Boolean used;

    @ManyToOne
    private UserAuthInterface userAuthInterface;

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

    public String getResetCode() {
        return resetCode;
    }

    public void setResetCode(String resetCode) {
        this.resetCode = resetCode;
    }

    public Boolean getUsed() {
        return used;
    }

    public void setUsed(Boolean used) {
        this.used = used;
    }

    public UserAuthInterface getUserAuthInterface() {
        return userAuthInterface;
    }

    public void setUserAuthInterface(UserAuthInterface userAuthInterface) {
        this.userAuthInterface = userAuthInterface;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PasswordReset that = (PasswordReset) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(resetCode, that.resetCode) &&
                Objects.equals(used, that.used) &&
                Objects.equals(userAuthInterface, that.userAuthInterface);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, createdAt, resetCode, used, userAuthInterface);
    }

    @Override
    public String toString() {
        return "PasswordReset{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", resetCode='" + resetCode + '\'' +
                ", used=" + used +
                ", userAuthInterface=" + userAuthInterface +
                '}';
    }
}
