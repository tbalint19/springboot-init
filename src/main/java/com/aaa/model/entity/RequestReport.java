package com.aaa.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class RequestReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;
    private String method;
    private LocalDateTime requestTime;

    @ManyToOne
    private UserAuthInterface userAuthInterface;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public LocalDateTime getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(LocalDateTime requestTime) {
        this.requestTime = requestTime;
    }

    public UserAuthInterface getUserAuthInterface() {
        return userAuthInterface;
    }

    public void setUserAuthInterface(UserAuthInterface userAuthInterface) {
        this.userAuthInterface = userAuthInterface;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestReport that = (RequestReport) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(url, that.url) &&
                Objects.equals(method, that.method) &&
                Objects.equals(requestTime, that.requestTime) &&
                Objects.equals(userAuthInterface, that.userAuthInterface);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, url, method, requestTime, userAuthInterface);
    }

    @Override
    public String toString() {
        return "RequestReport{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", requestTime=" + requestTime +
                ", userAuthInterface=" + userAuthInterface +
                '}';
    }
}
