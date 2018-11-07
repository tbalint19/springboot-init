package com.aaa.model.param;

import com.aaa.model.entity.DomainRole;
import com.aaa.model.entity.GroupAuthInterface;
import com.aaa.model.entity.GroupRole;

import java.util.Objects;

public class UserAuthInterfaceCreateParams {

    private String email;
    private String rawPassword;

    private Boolean passwordRequired;
    private Boolean manualConfirm;
    private Boolean manualPasswordSet;

    private DomainRole domainRole;

    private GroupAuthInterface groupAuthInterface;
    private GroupRole groupRole;

    private UserAuthInterfaceCreateParams(Builder builder) {
        setEmail(builder.email);
        setRawPassword(builder.rawPassword);
        setPasswordRequired(builder.passwordRequired);
        setManualConfirm(builder.manualConfirm);
        setManualPasswordSet(builder.manualPasswordSet);
        setDomainRole(builder.domainRole);
        setGroupAuthInterface(builder.groupAuthInterface);
        setGroupRole(builder.groupRole);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRawPassword() {
        return rawPassword;
    }

    public void setRawPassword(String rawPassword) {
        this.rawPassword = rawPassword;
    }

    public Boolean isPasswordRequired() {
        return passwordRequired;
    }

    public void setPasswordRequired(Boolean passwordRequired) {
        this.passwordRequired = passwordRequired;
    }

    public Boolean isManualConfirm() {
        return manualConfirm;
    }

    public void setManualConfirm(Boolean manualConfirm) {
        this.manualConfirm = manualConfirm;
    }

    public Boolean isManualPasswordSet() {
        return manualPasswordSet;
    }

    public void setManualPasswordSet(Boolean manualPasswordSet) {
        this.manualPasswordSet = manualPasswordSet;
    }

    public DomainRole getDomainRole() {
        return domainRole;
    }

    public void setDomainRole(DomainRole domainRole) {
        this.domainRole = domainRole;
    }

    public GroupAuthInterface getGroupAuthInterface() {
        return groupAuthInterface;
    }

    public void setGroupAuthInterface(GroupAuthInterface groupAuthInterface) {
        this.groupAuthInterface = groupAuthInterface;
    }

    public GroupRole getGroupRole() {
        return groupRole;
    }

    public void setGroupRole(GroupRole groupRole) {
        this.groupRole = groupRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAuthInterfaceCreateParams that = (UserAuthInterfaceCreateParams) o;
        return Objects.equals(email, that.email) &&
                Objects.equals(rawPassword, that.rawPassword) &&
                Objects.equals(manualConfirm, that.manualConfirm) &&
                Objects.equals(manualPasswordSet, that.manualPasswordSet) &&
                Objects.equals(domainRole, that.domainRole) &&
                Objects.equals(groupAuthInterface, that.groupAuthInterface) &&
                Objects.equals(groupRole, that.groupRole);
    }

    @Override
    public int hashCode() {

        return Objects.hash(email, rawPassword, manualConfirm, manualPasswordSet, domainRole, groupAuthInterface, groupRole);
    }

    @Override
    public String toString() {
        return "UserAuthInterfaceCreateParams{" +
                "email='" + email + '\'' +
                ", rawPassword='" + rawPassword + '\'' +
                ", manualConfirm=" + manualConfirm +
                ", manualPasswordSet=" + manualPasswordSet +
                ", domainRole=" + domainRole +
                ", groupAuthInterface=" + groupAuthInterface +
                ", groupRole=" + groupRole +
                '}';
    }


    public static final class Builder {
        private String email;
        private String rawPassword;
        private Boolean passwordRequired;
        private Boolean manualConfirm;
        private Boolean manualPasswordSet;
        private DomainRole domainRole;
        private GroupAuthInterface groupAuthInterface;
        private GroupRole groupRole;

        public Builder() {
        }

        public Builder email(String val) {
            email = val;
            return this;
        }

        public Builder rawPassword(String val) {
            rawPassword = val;
            return this;
        }

        public Builder passwordRequired(Boolean val) {
            passwordRequired = val;
            return this;
        }

        public Builder manualConfirm(Boolean val) {
            manualConfirm = val;
            return this;
        }

        public Builder manualPasswordSet(Boolean val) {
            manualPasswordSet = val;
            return this;
        }

        public Builder domainRole(DomainRole val) {
            domainRole = val;
            return this;
        }

        public Builder groupAuthInterface(GroupAuthInterface val) {
            groupAuthInterface = val;
            return this;
        }

        public Builder groupRole(GroupRole val) {
            groupRole = val;
            return this;
        }

        public UserAuthInterfaceCreateParams build() {
            return new UserAuthInterfaceCreateParams(this);
        }
    }
}
