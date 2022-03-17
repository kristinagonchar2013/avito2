package com.amr.project.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Email {

    private String[] to;
    private String cc;
    private String bcc;
    private String subject;
    private String content;
    private DataSource attachment;
}
