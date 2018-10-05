package com.aaa.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class DomainRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private List<DomainPermission> domainPermissions;
}
