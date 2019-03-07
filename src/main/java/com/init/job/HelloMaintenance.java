package com.init.job;

import com.init.repository.rdb.HelloRepository;
import com.init.service.TimeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class HelloMaintenance {

    private static Boolean shouldMonitor = false;

    private HelloRepository repository;
    private final TimeServiceImpl service;

    @Autowired
    public HelloMaintenance(HelloRepository repository, TimeServiceImpl service) {
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
            repository.deleteAll();
    }

}
