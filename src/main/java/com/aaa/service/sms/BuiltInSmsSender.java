package com.aaa.service.sms;

import com.aaa.model.dto.StatusResponse;
import org.springframework.stereotype.Service;

@Service
public class BuiltInSmsSender implements AuthSmsSender {
    @Override
    public StatusResponse sendConfirmSms(String code, String phoneNumber) {
        return new StatusResponse(false);
    }

}
