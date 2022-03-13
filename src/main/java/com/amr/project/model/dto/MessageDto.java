package com.amr.project.model.dto;

import com.amr.project.model.entity.Chat;
import com.amr.project.model.entity.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"id","chat", "to", "from"})
public class MessageDto {
    private Long id;
    private String textMessage;
    private boolean viewed;
    private LocalDateTime creationTime;
    private Chat chat;
    private User to;
    private User from;
}
