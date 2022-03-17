package com.amr.project.model.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
@Data
@Builder
public class Email {

    private String to;
    private String cc;
    private String bcc;
    private String subject;
    private String content;
    private DataSource attachment;
}
