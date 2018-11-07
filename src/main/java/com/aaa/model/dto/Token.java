package com.aaa.model.dto;

import java.util.List;

public class Token {

    private Long userAuthInterfaceId;
    private String domainRoleName;
    private List<GroupData> groupDataList;

    public AuthStatus exists() {
        return new AuthStatus();
    }

    public Long getUserAuthInterfaceId() {
        return userAuthInterfaceId;
    }

    public void setUserAuthInterfaceId(Long userAuthInterfaceId) {
        this.userAuthInterfaceId = userAuthInterfaceId;
    }

    public static class AuthStatus {

        private AuthStatus() {}

        public AuthStatus with() {
            return this;
        }

        public AuthStatus both() {
            return this;
        }

        public AuthStatus either() {
            return this;
        }

        public AuthStatus groupPermission(String name) {
            return this;
        }

        public AuthStatus forGroup(Long groupAuthInterfaceId) {
            return this;
        }

        public AuthStatus and() {
            return this;
        }

        public AuthStatus or() {
            return this;
        }

        public AuthStatus domainPermission(String name) {
            return this;
        }

    }

}
