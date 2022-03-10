package com.amr.project.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
    private int statusCode;
    private Date timestamp;
    private String message;
    private String description;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> errors;

    public ErrorMessage(int statusCode, Date timestamp, String message, String description) {
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.message = message;
        this.description = description;
    }

    public ErrorMessage(Date timestamp, String message, String description, List<String> errors) {
        this.timestamp = timestamp;
        this.message = message;
        this.description = description;
        this.errors = errors;
    }

    public ErrorMessage(Date timestamp, String message, String description) {
        this.timestamp = timestamp;
        this.message = message;
        this.description = description;
    }
}


