package com.amr.project.model.dto;

import com.amr.project.model.entity.Message;
import com.amr.project.model.entity.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"id","hash"})
public class ChatDto {
    private Long id;
    private Long hash;
    private List<User> members;
    private List<Message> messages;
}
