package com.aaa.model.entity;

import com.aaa.annotation.filterChain.AuthEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
public class UserAuthInterface extends AuthEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String phoneNumber;
    private String password;

    private Boolean passwordRequired;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public Boolean isAuthenticationRequired() {
        return passwordRequired;
    }

    public void setPasswordRequired(Boolean passwordRequired) {
        this.passwordRequired = passwordRequired;
    }

    public Boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
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

    public List<RequestReport> getRequestReports() {
        return requestReports;
    }

    public void setRequestReports(List<RequestReport> requestReports) {
        this.requestReports = requestReports;
    }

    public Boolean isPasswordRequired() {
        return passwordRequired;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAuthInterface that = (UserAuthInterface) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(username, that.username) &&
                Objects.equals(email, that.email) &&
                Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(password, that.password) &&
                Objects.equals(passwordRequired, that.passwordRequired) &&
                Objects.equals(confirmed, that.confirmed) &&
                Objects.equals(active, that.active) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(userAuthInterfaceConfirmations, that.userAuthInterfaceConfirmations) &&
                Objects.equals(domainRole, that.domainRole) &&
                Objects.equals(memberships, that.memberships) &&
                Objects.equals(passwordResets, that.passwordResets) &&
                Objects.equals(requestReports, that.requestReports);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, username, email, phoneNumber, password, passwordRequired, confirmed, active, createdAt, userAuthInterfaceConfirmations, domainRole, memberships, passwordResets, requestReports);
    }

    @Override
    public String toString() {
        return "UserAuthInterface{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", passwordRequired=" + passwordRequired +
                ", confirmed=" + confirmed +
                ", active=" + active +
                ", createdAt=" + createdAt +
                ", userAuthInterfaceConfirmations=" + userAuthInterfaceConfirmations +
                ", domainRole=" + domainRole +
                ", memberships=" + memberships +
                ", passwordResets=" + passwordResets +
                ", requestReports=" + requestReports +
                '}';
    }
}
