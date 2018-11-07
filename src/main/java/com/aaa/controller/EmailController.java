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

    public AttemptResponse sendConfirmation() {
        String subject = "Account confirmation";
        String to = null;
        String text = renderer.render("confirmation.ftl", null);
        sender.attemptSend(to, subject, text);
        return new AttemptResponse(true);
    }

    public AttemptResponse sendReset() {
        String subject = "Password reset";
        String to = null;
        String text = renderer.render("reset.ftl", null);
        sender.attemptSend(to, subject, text);
        return new AttemptResponse(true);
    }

    public AttemptResponse sendCustomMail() {
        return new AttemptResponse(true);
    }

}
