package com.init.service.sms;

import com.init.model.dto.AttemptResponse;
import org.springframework.stereotype.Service;

@Service
public class BuiltInSmsSender implements AuthSmsSender {
    @Override
    public AttemptResponse sendConfirmSms(String code, String phoneNumber) {
        return null;
    }

}
