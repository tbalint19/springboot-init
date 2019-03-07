package com.init.service.email;

import java.util.concurrent.CompletableFuture;

public interface EmailSenderService {

    CompletableFuture<Boolean> attemptSend(String to, String subject, String text);
}
