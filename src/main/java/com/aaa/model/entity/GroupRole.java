package com.aaa.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class GroupRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    private List<GroupPermission> groupPermissions;

    @ManyToOne
    private List<Membership> memberships;
}
