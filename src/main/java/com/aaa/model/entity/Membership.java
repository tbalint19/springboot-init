package com.aaa.model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Membership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean active;

    @ManyToOne
    private UserAuthInterface userAuthInterface;

    @ManyToOne
    private GroupAuthInterface groupAuthInterface;

    @ManyToOne
    private GroupRole groupRole;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public UserAuthInterface getUserAuthInterface() {
        return userAuthInterface;
    }

    public void setUserAuthInterface(UserAuthInterface userAuthInterface) {
        this.userAuthInterface = userAuthInterface;
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
        Membership that = (Membership) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(active, that.active) &&
                Objects.equals(userAuthInterface, that.userAuthInterface) &&
                Objects.equals(groupAuthInterface, that.groupAuthInterface) &&
                Objects.equals(groupRole, that.groupRole);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, active, userAuthInterface, groupAuthInterface, groupRole);
    }

    @Override
    public String toString() {
        return "Membership{" +
                "id=" + id +
                ", active=" + active +
                ", userAuthInterface=" + userAuthInterface +
                ", groupAuthInterface=" + groupAuthInterface +
                ", groupRole=" + groupRole +
                '}';
    }
}
