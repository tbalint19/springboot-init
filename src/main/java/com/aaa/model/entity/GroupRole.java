package com.aaa.model.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class GroupRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "groupPermission_of_groupRole",
            joinColumns = @JoinColumn(name = "groupRole_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "groupPermission_id", referencedColumnName = "id"))
    private List<GroupPermission> groupPermissions;

    @OneToMany(mappedBy = "groupRole")
    private List<Membership> memberships;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GroupPermission> getGroupPermissions() {
        return groupPermissions;
    }

    public void setGroupPermissions(List<GroupPermission> groupPermissions) {
        this.groupPermissions = groupPermissions;
    }

    public List<Membership> getMemberships() {
        return memberships;
    }

    public void setMemberships(List<Membership> memberships) {
        this.memberships = memberships;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupRole groupRole = (GroupRole) o;
        return Objects.equals(id, groupRole.id) &&
                Objects.equals(name, groupRole.name) &&
                Objects.equals(groupPermissions, groupRole.groupPermissions) &&
                Objects.equals(memberships, groupRole.memberships);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, groupPermissions, memberships);
    }

    @Override
    public String toString() {
        return "GroupRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", groupPermissions=" + groupPermissions +
                ", memberships=" + memberships +
                '}';
    }
}
