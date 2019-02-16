package com.aaa.service.sms;

import com.aaa.model.dto.AttemptResponse;
import org.springframework.stereotype.Service;

@Service
public class BuiltInSmsSender implements AuthSmsSender {
    @Override
    public AttemptResponse sendConfirmSms(String code, String phoneNumber) {
        return null;
    }

}
