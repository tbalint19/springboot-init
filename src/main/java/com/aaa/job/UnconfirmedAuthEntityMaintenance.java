package com.aaa.job;

import com.aaa.repository.rdb.AuthEntityRepository;
import com.aaa.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UnconfirmedAuthEntityMaintenance {

    private static Boolean shouldMonitor = false;

    private final AuthEntityRepository repository;
    private final TimeService service;

    @Autowired
    public UnconfirmedAuthEntityMaintenance(AuthEntityRepository repository, TimeService service) {
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
    public void deleteUnconfirmedAuthEntities() {
        if (shouldMonitor)
            repository.deleteAllByConfirmedAndCreatedAtIsBefore(
                    false, service.getNow().minusHours(24L));
    }

}
