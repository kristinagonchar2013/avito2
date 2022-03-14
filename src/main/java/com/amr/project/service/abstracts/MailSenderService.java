package com.amr.project.service.abstracts;

public interface MailSenderService {
    void sendMail(String emailTo, String subject, String message);
}
