package com.aaa.annotation.filterChain;

import java.util.List;

public abstract class PermissionResolver {

    String cleanse(String permissionName) {
        return permissionName.replace(" ", "").toLowerCase();
    }
}
