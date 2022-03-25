package com.amr.project.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class FeedbackDTO {
    private Long id;
    private String reason;
    private String fullText;
    private LocalDateTime dateTime;
    private UserDto user;
}
