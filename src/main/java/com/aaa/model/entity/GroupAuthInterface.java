package com.aaa.model.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "domain_group")
public class GroupAuthInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean active;

    @OneToMany(mappedBy = "group")
    private List<Membership> memberships;

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
        GroupAuthInterface groupAuthInterface = (GroupAuthInterface) o;
        return Objects.equals(id, groupAuthInterface.id) &&
                Objects.equals(active, groupAuthInterface.active) &&
                Objects.equals(memberships, groupAuthInterface.memberships);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, active, memberships);
    }

    @Override
    public String toString() {
        return "GroupAuthInterface{" +
                "id=" + id +
                ", active=" + active +
                ", memberships=" + memberships +
                '}';
    }
}
