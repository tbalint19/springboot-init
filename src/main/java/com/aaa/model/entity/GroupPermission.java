package com.aaa.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class GroupPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    private List<GroupRole> groupRoles;
}
