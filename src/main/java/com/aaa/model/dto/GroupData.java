package com.aaa.model.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class GroupData implements Serializable {
    private Long groupId;
    private List<String> permissions;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return Objects.equals(groupId, groupData.groupId) &&
                Objects.equals(permissions, groupData.permissions);
    }

    @Override
    public int hashCode() {

        return Objects.hash(groupId, permissions);
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "groupId=" + groupId +
                ", permissions=" + permissions +
                '}';
    }
}
