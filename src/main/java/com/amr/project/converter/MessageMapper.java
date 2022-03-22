package com.amr.project.converter;

import com.amr.project.model.dto.MessageDto;
import com.amr.project.model.entity.Message;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MessageMapper {

    Message messageDtoToMessage(MessageDto messageDto);
    MessageDto messageToMessageDto(Message message);
    List<MessageDto> listOfMessageToMessageDto(List<Message> list);
    MessageDto activationMessageToMessageDto (String message);
}
