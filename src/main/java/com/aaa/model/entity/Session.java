package com.aaa.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@RedisHash("Session")
public class Session implements Serializable {

    @Id
    private String id;

    @Indexed
    private String sessionId;

    @Indexed
    private Long userId;

    private List<String> permissions;
    private List<GroupData> groups;
    private LocalDateTime createdAt;
    private LocalDateTime lastUsedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    public List<GroupData> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupData> groups) {
        this.groups = groups;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getLastUsedAt() {
        return lastUsedAt;
    }

    public void setLastUsedAt(LocalDateTime lastUsedAt) {
        this.lastUsedAt = lastUsedAt;
    }

    public static class GroupData implements Serializable {
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

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        return Objects.equals(sessionId, session.sessionId) &&
                Objects.equals(userId, session.userId) &&
                Objects.equals(permissions, session.permissions) &&
                Objects.equals(groups, session.groups) &&
                Objects.equals(createdAt, session.createdAt) &&
                Objects.equals(lastUsedAt, session.lastUsedAt);
    }

    @Override
    public int hashCode() {

        return Objects.hash(sessionId, userId, permissions, groups, createdAt, lastUsedAt);
    }

    @Override
    public String toString() {
        return "Session{" +
                "sessionId='" + sessionId + '\'' +
                ", userId='" + userId + '\'' +
                ", permissions=" + permissions +
                ", groups=" + groups +
                ", createdAt=" + createdAt +
                ", lastUsedAt=" + lastUsedAt +
                '}';
    }
}
