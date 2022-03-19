package com.amr.project.service.abstracts;

import com.amr.project.model.domain.Email;

public interface EmailService {

    void sendEmail(Email email);
}
