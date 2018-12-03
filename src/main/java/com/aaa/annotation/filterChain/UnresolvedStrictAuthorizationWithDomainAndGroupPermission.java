package com.aaa.annotation.filterChain;

import com.aaa.model.dto.GroupData;
import com.aaa.model.entity.Session;
import com.aaa.model.exception.HTTP403;

import java.util.Optional;

public class UnresolvedStrictAuthorizationWithDomainAndGroupPermission {

    private Session session;
    private String permissionName;

    UnresolvedStrictAuthorizationWithDomainAndGroupPermission(Session session, String permissionName) {
        this.session = session;
        this.permissionName = permissionName;
    }

    public void forAnyGroup() throws HTTP403 {

    }

    public void forGroup(Long groupId) throws HTTP403 {
       Optional<GroupData> groupData = session.getGroups()
               .stream()
               .filter(group -> group.getGroupId().equals(groupId))
               .findFirst();

       if (!groupData.isPresent()) throw new HTTP403("Group permission missing for group");
       if (!groupData.get().getPermissions().contains(permissionName)) throw new HTTP403("Group permission missing for group");
    }
}
