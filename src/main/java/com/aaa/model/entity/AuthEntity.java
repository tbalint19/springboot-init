package com.aaa.model.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
public class AuthEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdAt;
    private String referenceId;
    private String email;
    private String password;
    private Boolean confirmed;
    private Boolean active;

    @OneToMany(mappedBy = "authEntity")
    private List<AuthEntityConfirmation> authEntityConfirmations;

    @ManyToOne
    private DomainRole domainRole;

    @OneToMany(mappedBy = "authEntity")
    private List<Membership> memberships;

    @OneToMany(mappedBy = "authEntity")
    private List<PasswordReset> passwordResets;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
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

    public List<AuthEntityConfirmation> getAuthEntityConfirmations() {
        return authEntityConfirmations;
    }

    public void setAuthEntityConfirmations(List<AuthEntityConfirmation> authEntityConfirmations) {
        this.authEntityConfirmations = authEntityConfirmations;
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
        AuthEntity that = (AuthEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(referenceId, that.referenceId) &&
                Objects.equals(email, that.email) &&
                Objects.equals(password, that.password) &&
                Objects.equals(confirmed, that.confirmed) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(authEntityConfirmations, that.authEntityConfirmations) &&
                Objects.equals(domainRole, that.domainRole) &&
                Objects.equals(memberships, that.memberships) &&
                Objects.equals(passwordResets, that.passwordResets);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, referenceId, email, password, confirmed, createdAt, authEntityConfirmations, domainRole, memberships, passwordResets);
    }

    @Override
    public String toString() {
        return "AuthEntity{" +
                "id=" + id +
                ", referenceId='" + referenceId + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confirmed=" + confirmed +
                ", createdAt=" + createdAt +
                ", authEntityConfirmations=" + authEntityConfirmations +
                ", domainRole=" + domainRole +
                ", memberships=" + memberships +
                ", passwordResets=" + passwordResets +
                '}';
    }
}
