package com.amr.project.converter;

import com.amr.project.model.dto.MessageDto;
import com.amr.project.model.entity.Message;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper {

    Message messageDtoToMessage(MessageDto messageDto);
    MessageDto messageToMessageDto(Message message);
}
