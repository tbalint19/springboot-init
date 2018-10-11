package com.aaa.model.dto;

import java.io.Serializable;
import java.util.Objects;

public class MaintenanceStatus implements Serializable {

    private Boolean entityMaintenanceActive;
    private Boolean sessionMaintenanceActive;
    private Boolean confirmationMaintenanceActive;
    private Boolean resetMaintenanceActive;


    public Boolean getEntityMaintenanceActive() {
        return entityMaintenanceActive;
    }

    public void setEntityMaintenanceActive(Boolean entityMaintenanceActive) {
        this.entityMaintenanceActive = entityMaintenanceActive;
    }

    public Boolean getSessionMaintenanceActive() {
        return sessionMaintenanceActive;
    }

    public void setSessionMaintenanceActive(Boolean sessionMaintenanceActive) {
        this.sessionMaintenanceActive = sessionMaintenanceActive;
    }

    public Boolean getConfirmationMaintenanceActive() {
        return confirmationMaintenanceActive;
    }

    public void setConfirmationMaintenanceActive(Boolean confirmationMaintenanceActive) {
        this.confirmationMaintenanceActive = confirmationMaintenanceActive;
    }

    public Boolean getResetMaintenanceActive() {
        return resetMaintenanceActive;
    }

    public void setResetMaintenanceActive(Boolean resetMaintenanceActive) {
        this.resetMaintenanceActive = resetMaintenanceActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaintenanceStatus that = (MaintenanceStatus) o;
        return Objects.equals(entityMaintenanceActive, that.entityMaintenanceActive) &&
                Objects.equals(sessionMaintenanceActive, that.sessionMaintenanceActive) &&
                Objects.equals(confirmationMaintenanceActive, that.confirmationMaintenanceActive) &&
                Objects.equals(resetMaintenanceActive, that.resetMaintenanceActive);
    }

    @Override
    public int hashCode() {

        return Objects.hash(entityMaintenanceActive, sessionMaintenanceActive, confirmationMaintenanceActive, resetMaintenanceActive);
    }

    @Override
    public String toString() {
        return "MaintenanceStatus{" +
                "entityMaintenanceActive=" + entityMaintenanceActive +
                ", sessionMaintenanceActive=" + sessionMaintenanceActive +
                ", confirmationMaintenanceActive=" + confirmationMaintenanceActive +
                ", resetMaintenanceActive=" + resetMaintenanceActive +
                '}';
    }
}
