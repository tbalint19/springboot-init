package com.aaa.model.entity;

import com.aaa.model.dto.GroupData;
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
    private Long userAuthInterfaceId;

    private List<String> permissions;
    private List<GroupData> groups;
    private LocalDateTime createdAt;
    private LocalDateTime lastUsedAt;

    private String confirmCode;
    private Boolean confirmed;

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

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Long getUserAuthInterfaceId() {
        return userAuthInterfaceId;
    }

    public void setUserAuthInterfaceId(Long userAuthInterfaceId) {
        this.userAuthInterfaceId = userAuthInterfaceId;
    }

    public Boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        return Objects.equals(id, session.id) &&
                Objects.equals(sessionId, session.sessionId) &&
                Objects.equals(userAuthInterfaceId, session.userAuthInterfaceId) &&
                Objects.equals(permissions, session.permissions) &&
                Objects.equals(groups, session.groups) &&
                Objects.equals(createdAt, session.createdAt) &&
                Objects.equals(lastUsedAt, session.lastUsedAt) &&
                Objects.equals(confirmed, session.confirmed);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, sessionId, userAuthInterfaceId, permissions, groups, createdAt, lastUsedAt, confirmed);
    }

    @Override
    public String toString() {
        return "Session{" +
                "id='" + id + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", userAuthInterfaceId=" + userAuthInterfaceId +
                ", permissions=" + permissions +
                ", groups=" + groups +
                ", createdAt=" + createdAt +
                ", lastUsedAt=" + lastUsedAt +
                ", confirmed=" + confirmed +
                '}';
    }
}
