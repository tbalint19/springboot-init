package com.aaa.job;

import com.aaa.repository.redis.SessionRepository;
import com.aaa.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ExpiredSessionMaintenance {

    private static Boolean shouldMonitor = false;

    private SessionRepository repository;
    private TimeService service;

    @Autowired
    public ExpiredSessionMaintenance(SessionRepository repository, TimeService service) {
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
    public void deleteExpiredSessions() {
        if (shouldMonitor)
            repository.deleteAllByCreatedAtBefore(service.getNow().minusHours(24L));
    }

}
