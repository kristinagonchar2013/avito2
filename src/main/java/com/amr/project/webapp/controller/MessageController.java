package com.amr.project.webapp.controller;

import com.amr.project.converter.MessageMapper;
import com.amr.project.model.dto.MessageDto;
import com.amr.project.service.abstracts.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private final SimpMessagingTemplate template;
    private final MessageService messageService;
    private final MessageMapper messageMapper;

    @Autowired
    public MessageController(SimpMessagingTemplate template, MessageService messageService, MessageMapper messageMapper) {
        this.template = template;
        this.messageService = messageService;
        this.messageMapper = messageMapper;
    }

    @MessageMapping("chat/{id}/sendMessage")
    public void sendMessage(@PathVariable Long id, @Payload MessageDto messageDto) {
        messageService.persist(messageMapper.messageDtoToMessage(messageDto));
        template.convertAndSendToUser(messageDto.getTo().getUsername(), "/chat/" + id, messageDto);
    }

}
