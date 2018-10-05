package com.aaa.model.entity;

import javax.persistence.*;

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
}
