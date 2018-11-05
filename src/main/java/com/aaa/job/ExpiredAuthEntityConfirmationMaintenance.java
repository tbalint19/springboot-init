package com.aaa.job;

import com.aaa.repository.rdb.UserAuthInterfaceConfirmationRepository;
import com.aaa.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ExpiredAuthEntityConfirmationMaintenance {

    private static Boolean shouldMonitor = false;

    private UserAuthInterfaceConfirmationRepository repository;
    private TimeService service;

    @Autowired
    public ExpiredAuthEntityConfirmationMaintenance(UserAuthInterfaceConfirmationRepository repository, TimeService service) {
        this.repository = repository;
        this.service = service;
    }

    public static Boolean getShouldMonitor() {
        return shouldMonitor;
    }

    public static void setShouldMonitor(Boolean to) {
        shouldMonitor = to;
    }

    @Transactional
    @Scheduled(fixedRate = 60000)
    public void deleteExpiredConfirmations() {
        if (shouldMonitor)
            repository.deleteAllByUsedAndCreatedAtBefore(false, service.getNow().minusHours(24L));
    }
}
