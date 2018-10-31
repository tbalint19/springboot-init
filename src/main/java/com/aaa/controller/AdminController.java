package com.aaa.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/_")
public class AdminController {

    // domain permissions and group permissions are domain related, and created on startup
    // extra features with new endpoints that require new permissions will lead to new deploy (new config)
    // thus permission admin endpoints are not required

    // API
    // - create group
    // - delete group
    // - toggle activation of group

    // - add to group - create membership
    // - remove from group - delete membership
    // - toggle activation of membership

}
