package com.amr.project.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Schema(description = "Чат пользователей")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"id", "hash"})
public class ChatDto {
    private Long id;
    private Long hash;
    private Set<UserDto> members;
    private List<MessageDto> messages;
}
