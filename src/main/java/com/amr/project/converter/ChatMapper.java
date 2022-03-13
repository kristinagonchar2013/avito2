package com.amr.project.converter;

import com.amr.project.model.dto.ChatDto;
import com.amr.project.model.entity.Chat;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChatMapper {

    Chat chatDtoToChat(ChatDto chatDto);
    ChatDto chatToChatDto(Chat chat);
}
