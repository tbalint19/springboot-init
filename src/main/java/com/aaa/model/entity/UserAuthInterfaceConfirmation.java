package com.aaa.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class UserAuthInterfaceConfirmation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdAt;
    private String confirmCode;
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
        UserAuthInterfaceConfirmation that = (UserAuthInterfaceConfirmation) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(confirmCode, that.confirmCode) &&
                Objects.equals(used, that.used) &&
                Objects.equals(userAuthInterface, that.userAuthInterface);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, createdAt, confirmCode, used, userAuthInterface);
    }

    @Override
    public String toString() {
        return "UserAuthInterfaceConfirmation{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", confirmCode='" + confirmCode + '\'' +
                ", used=" + used +
                ", userAuthInterface=" + userAuthInterface +
                '}';
    }
}
