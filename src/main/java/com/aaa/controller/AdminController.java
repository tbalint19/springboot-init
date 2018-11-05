package com.aaa.controller;

import com.aaa.model.dto.StatusResponse;
import com.aaa.model.entity.GroupAuthInterface;
import com.aaa.model.entity.UserAuthInterface;
import org.springframework.stereotype.Component;

@Component
public class AdminController {

    public UserAuthInterface createAuthInterface() {
        return null;
    }

    public StatusResponse toggleAuthInterface() { return new StatusResponse(true); }

    public StatusResponse deleteAuthInterface() { return new StatusResponse(true); }

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

    public StatusResponse createDomainRole() {
        return new StatusResponse(true);
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
