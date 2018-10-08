package com.aaa.model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Membership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private AuthEntity authEntity;

    @ManyToOne
    private Group group;

    @ManyToOne
    private GroupRole groupRole;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AuthEntity getAuthEntity() {
        return authEntity;
    }

    public void setAuthEntity(AuthEntity authEntity) {
        this.authEntity = authEntity;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
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
                Objects.equals(authEntity, that.authEntity) &&
                Objects.equals(group, that.group) &&
                Objects.equals(groupRole, that.groupRole);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, authEntity, group, groupRole);
    }

    @Override
    public String toString() {
        return "Membership{" +
                "id=" + id +
                ", authEntity=" + authEntity +
                ", group=" + group +
                ", groupRole=" + groupRole +
                '}';
    }
}
