package com.aaa.controller;

import com.aaa.model.dto.AttemptResponse;
import com.aaa.service.email.BuiltInMailSender;
import com.aaa.service.email.TemplateRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailController {

    private BuiltInMailSender sender;
    private TemplateRenderer renderer;

    @Autowired
    public EmailController(BuiltInMailSender sender, TemplateRenderer renderer) {
        this.sender = sender;
        this.renderer = renderer;
    }

    AttemptResponse sendConfirmation(String to) {
        String subject = "Account confirmation";
        String text = renderer.render("confirmation.ftl", null);
        sender.attemptSend(to, subject, text);
        return new AttemptResponse(true);
    }

    AttemptResponse sendReset(String to) {
        String subject = "Password reset";
        String text = renderer.render("reset.ftl", null);
        sender.attemptSend(to, subject, text);
        return new AttemptResponse(true);
    }

}
