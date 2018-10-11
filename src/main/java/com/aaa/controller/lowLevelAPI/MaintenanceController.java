package com.aaa.controller.lowLevelAPI;

import com.aaa.job.ExpiredAuthEntityConfirmationMaintenance;
import com.aaa.job.ExpiredPasswordResetMaintenance;
import com.aaa.job.ExpiredSessionMaintenance;
import com.aaa.job.UnconfirmedAuthEntityMaintenance;
import com.aaa.model.dto.MaintenanceStatus;
import com.aaa.model.dto.StatusResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/maintenance")
public class MaintenanceController {

    @GetMapping("/toggle")
    public StatusResponse toggleMaintenance(@PathVariable String maintenance, @RequestParam Boolean to) {
        switch (maintenance) {
            case "entity":
                UnconfirmedAuthEntityMaintenance.setShouldMonitor(to);
                return new StatusResponse(true);
            case "session":
                ExpiredSessionMaintenance.setShouldMonitor(to);
                return new StatusResponse(true);
            case "reset":
                ExpiredPasswordResetMaintenance.setShouldMonitor(to);
                return new StatusResponse(true);
            case "confirmation":
                ExpiredAuthEntityConfirmationMaintenance.setShouldMonitor(to);
                return new StatusResponse(true);
            default:
                return new StatusResponse(false);
        }
    }

    @GetMapping("/status")
    public MaintenanceStatus getMaintenanceStatus() {
        MaintenanceStatus status = new MaintenanceStatus();

        status.setEntityMaintenanceActive(UnconfirmedAuthEntityMaintenance.getShouldMonitor());
        status.setSessionMaintenanceActive(ExpiredSessionMaintenance.getShouldMonitor());
        status.setConfirmationMaintenanceActive(ExpiredAuthEntityConfirmationMaintenance.getShouldMonitor());
        status.setResetMaintenanceActive(ExpiredPasswordResetMaintenance.getShouldMonitor());

        return status;
    }
}
