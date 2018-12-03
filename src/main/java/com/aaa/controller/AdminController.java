package com.aaa.controller;

import com.aaa.model.dto.StatusResponse;
import com.aaa.model.entity.*;
import com.aaa.model.param.UserAuthInterfaceCreateParams;
import com.aaa.service.ConfirmationService;
import com.aaa.service.PasswordResetService;
import com.aaa.service.UserAuthInterfaceService;
import com.aaa.service.HashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdminController {

    private HashService hash;
    private UserAuthInterfaceService userAuthInterfaceService;
    private ConfirmationService confirmationService;
    private PasswordResetService passwordResetService;
    private EmailController emailController;

    @Autowired
    public AdminController(
            HashService hashService,
            UserAuthInterfaceService userAuthInterfaceService,
            ConfirmationService confirmationService,
            PasswordResetService passwordResetService,
            EmailController emailController) {
        this.hash = hashService;
        this.userAuthInterfaceService = userAuthInterfaceService;
        this.confirmationService = confirmationService;
        this.passwordResetService = passwordResetService;
        this.emailController = emailController;
    }

    public UserAuthInterface createUserAuthInterface(UserAuthInterfaceCreateParams params) {
        String username = params.getUsername();
        String email = params.getEmail();
        String phoneNumber = params.getEmail();
        String rawPassword = params.getRawPassword();
        Boolean manualConfirm = params.isManualConfirm();
        Boolean manualPasswordSet = params.isManualPasswordSet();
        Boolean passwordRequired = params.isPasswordRequired();

        UserAuthInterface userAuthInterface = userAuthInterfaceService.create(username,
                email, phoneNumber, hash.create(rawPassword), manualConfirm, manualPasswordSet, passwordRequired);
        userAuthInterfaceService.save(userAuthInterface);

        if (manualConfirm) {
            UserAuthInterfaceConfirmation confirmation = confirmationService.create(userAuthInterface);
            confirmationService.save(confirmation);
            emailController.sendConfirmation(email);
        }

        if (manualPasswordSet) {
            PasswordReset reset = passwordResetService.create(userAuthInterface);
            passwordResetService.save(reset);
            emailController.sendReset(email);
        }

        DomainRole domainRole = params.getDomainRole();
        if (domainRole != null) {
            userAuthInterface.setDomainRole(domainRole);
            userAuthInterfaceService.save(userAuthInterface);
        }

        GroupAuthInterface groupAuthInterface = params.getGroupAuthInterface();
        GroupRole groupRole = params.getGroupRole();
        if (groupAuthInterface != null && groupRole != null) {
            createMembership(/* TODO - DTO */);
        }

        return userAuthInterface;
    }

    public StatusResponse toggleUserAuthInterface() {
        return new StatusResponse(true);
    }

    public StatusResponse deleteUserAuthInterface() { return new StatusResponse(true); }

    public GroupAuthInterface createGroup() {
        return null;
    }

    public StatusResponse toggleGroup() {
        return new StatusResponse(true);
    }

    public StatusResponse deleteGroup() {
        return new StatusResponse(true);
    }

    public StatusResponse createMembership() {
        return new StatusResponse(true);
    }

    public StatusResponse toggleMembership() {
        return new StatusResponse(true);
    }

    public StatusResponse deleteMembership() {
        return new StatusResponse(true);
    }

    public DomainRole createDomainRole(String name, List<DomainPermission> permissions) {
        return null;
    }

    public StatusResponse togglePermissionForDomainRole() {
        return new StatusResponse(true);
    }

    public StatusResponse deleteDomainRole() {
        return new StatusResponse(true);
    }

    public StatusResponse createGroupRole() { return new StatusResponse(true); }

    public StatusResponse togglePermissionForGroupRole() {
        return new StatusResponse(true);
    }

    public StatusResponse deleteGroupRole() {
        return new StatusResponse(true);
    }

}
