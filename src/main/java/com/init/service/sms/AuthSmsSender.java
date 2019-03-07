package com.init.service.sms;

import com.init.model.dto.AttemptResponse;

public interface AuthSmsSender {

    AttemptResponse sendConfirmSms(String code, String phoneNumber);

}
