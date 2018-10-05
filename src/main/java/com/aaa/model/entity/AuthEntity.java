package com.aaa.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class AuthEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String referenceId;
    private String email;
    private String password;

    @OneToMany(mappedBy = "authEntity")
    private List<AuthEntityConfirmation> authEntityConfirmations;

    @ManyToOne
    private DomainRole domainRole;

    @OneToMany(mappedBy = "authEntity")
    private List<Membership> memberships;

    @OneToMany(mappedBy = "authEntity")
    private List<PasswordReset> passwordResets;
}
