package com.amr.project.converter;

import com.amr.project.model.dto.ChatDto;
import com.amr.project.model.entity.Chat;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface ChatMapper {

    Chat chatDtoToChat(ChatDto chatDto);
    ChatDto chatToChatDto(Chat chat);
    Set<ChatDto> setOfChatToChatDto(Set<Chat> chatSet);
}
