package com.init.mockService;

import com.init.service.TimeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
@Profile("test")
public class TimeServiceMock implements TimeService {

    private LocalDateTime now;

    public TimeServiceMock() {
        this.now = null;
    }

    public LocalDateTime getNow() {
        if (now == null) {
            this.now = LocalDateTime.now(ZoneId.of("UTC"));
        }
        return now;
    }

    public void skipHours(Integer hoursToSkip) {
        this.now = this.now.plusHours(hoursToSkip);
    }

    public void skipMinutes(Integer minutesToSkip) {
        this.now = this.now.plusMinutes(minutesToSkip);
    }
}
