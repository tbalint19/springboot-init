package com.aaa.service.sms;

import com.aaa.model.dto.AttemptResponse;

public interface AuthSmsSender {

    AttemptResponse sendConfirmSms(String code, String phoneNumber);

}
