package com.aaa.annotation.filterChain;

import com.aaa.model.dto.GroupData;
import com.aaa.model.entity.Session;
import com.aaa.model.exception.HTTP403;

import java.util.Optional;

public class UnresolvedLazyAuthorizationWithDomainAndGroupPermission {

    private Session session;
    private Boolean shouldPassBasedOnDomain;
    private Boolean shouldPassBasedOnGroup;
    private String groupPermission;

    UnresolvedLazyAuthorizationWithDomainAndGroupPermission(Session session, Boolean pass1, Boolean pass2, String permission) {
        this.session = session;
        this.shouldPassBasedOnDomain = pass1;
        this.shouldPassBasedOnGroup = pass2;
        this.groupPermission = permission;
    }

    public void forAnyGroup() throws HTTP403 {
        if (!(shouldPassBasedOnDomain || shouldPassBasedOnGroup)) throw new HTTP403("Both permissions missing");
    }

    public void forGroup(Long groupId) throws HTTP403 {
        if (!(shouldPass(groupId) || shouldPassBasedOnDomain)) throw new HTTP403("Both permissions missing");
    }

    private Boolean shouldPass(Long groupId) {
        Optional<GroupData> groupData = session.getGroups()
                .stream()
                .filter(group -> group.getGroupId().equals(groupId))
                .findFirst();

        if (!groupData.isPresent()) return false;
        if (!groupData.get().getPermissions().contains(groupPermission)) return false;
        return true;
    }
}
