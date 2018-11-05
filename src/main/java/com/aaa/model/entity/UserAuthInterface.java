package com.aaa.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
public class UserAuthInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private Boolean confirmed;
    private Boolean active;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "userAuthInterface")
    private List<UserAuthInterfaceConfirmation> userAuthInterfaceConfirmations;

    @ManyToOne
    private DomainRole domainRole;

    @OneToMany(mappedBy = "userAuthInterface")
    private List<Membership> memberships;

    @OneToMany(mappedBy = "userAuthInterface")
    private List<PasswordReset> passwordResets;

    @OneToMany(mappedBy = "userAuthInterface")
    private List<RequestReport> requestReports;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UserAuthInterfaceConfirmation> getUserAuthInterfaceConfirmations() {
        return userAuthInterfaceConfirmations;
    }

    public void setUserAuthInterfaceConfirmations(List<UserAuthInterfaceConfirmation> userAuthInterfaceConfirmations) {
        this.userAuthInterfaceConfirmations = userAuthInterfaceConfirmations;
    }

    public DomainRole getDomainRole() {
        return domainRole;
    }

    public void setDomainRole(DomainRole domainRole) {
        this.domainRole = domainRole;
    }

    public List<Membership> getMemberships() {
        return memberships;
    }

    public void setMemberships(List<Membership> memberships) {
        this.memberships = memberships;
    }

    public List<PasswordReset> getPasswordResets() {
        return passwordResets;
    }

    public void setPasswordResets(List<PasswordReset> passwordResets) {
        this.passwordResets = passwordResets;
    }

    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAuthInterface that = (UserAuthInterface) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(email, that.email) &&
                Objects.equals(password, that.password) &&
                Objects.equals(confirmed, that.confirmed) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(userAuthInterfaceConfirmations, that.userAuthInterfaceConfirmations) &&
                Objects.equals(domainRole, that.domainRole) &&
                Objects.equals(memberships, that.memberships) &&
                Objects.equals(passwordResets, that.passwordResets);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, email, password, confirmed, createdAt, userAuthInterfaceConfirmations, domainRole, memberships, passwordResets);
    }

    @Override
    public String toString() {
        return "UserAuthInterface{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confirmed=" + confirmed +
                ", createdAt=" + createdAt +
                ", userAuthInterfaceConfirmations=" + userAuthInterfaceConfirmations +
                ", domainRole=" + domainRole +
                ", memberships=" + memberships +
                ", passwordResets=" + passwordResets +
                '}';
    }
}
