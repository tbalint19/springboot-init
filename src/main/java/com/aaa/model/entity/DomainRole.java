package com.aaa.model.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
public class DomainRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "domainPermission_of_domainRole",
            joinColumns = @JoinColumn(name = "domainRole_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "domainPermission_id", referencedColumnName = "id"))
    private Collection<DomainPermission> domainPermissions;

    @OneToMany(mappedBy = "domainRole")
    private List<UserAuthInterface> authEntities;

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

    public Collection<DomainPermission> getDomainPermissions() {
        return domainPermissions;
    }

    public void setDomainPermissions(Collection<DomainPermission> domainPermissions) {
        this.domainPermissions = domainPermissions;
    }

    public List<UserAuthInterface> getAuthEntities() {
        return authEntities;
    }

    public void setAuthEntities(List<UserAuthInterface> authEntities) {
        this.authEntities = authEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DomainRole that = (DomainRole) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(domainPermissions, that.domainPermissions) &&
                Objects.equals(authEntities, that.authEntities);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, domainPermissions, authEntities);
    }

    @Override
    public String toString() {
        return "DomainRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", domainPermissions=" + domainPermissions +
                ", authEntities=" + authEntities +
                '}';
    }
}
