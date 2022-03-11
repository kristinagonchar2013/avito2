package com.amr.project.service.abstracts;

public interface MailSender {
    void sendMail(String emailTo, String subject, String message);
}
