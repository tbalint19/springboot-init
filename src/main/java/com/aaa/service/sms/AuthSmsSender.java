package com.aaa.service.sms;

import com.aaa.model.dto.StatusResponse;

public interface AuthSmsSender {

    StatusResponse sendConfirmSms(String code, String phoneNumber);

}
