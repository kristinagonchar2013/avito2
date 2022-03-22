package com.amr.project.webapp.controller;

import com.amr.project.converter.MessageMapper;
import com.amr.project.model.dto.MessageDto;
import com.amr.project.service.abstracts.MessageService;
import com.amr.project.service.abstracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class MessageController {

    private final SimpMessagingTemplate template;
    private final MessageService messageService;
    private final MessageMapper messageMapper;
    private final UserService userService;

    @Autowired
    public MessageController(SimpMessagingTemplate template, MessageService messageService, MessageMapper messageMapper, UserService userService) {
        this.template = template;
        this.messageService = messageService;
        this.messageMapper = messageMapper;
        this.userService = userService;
    }

    @MessageMapping("/chat")
    public void sendMessage(@Payload MessageDto messageDto) {
        messageDto.setCreationTime(LocalDateTime.now());
        messageService.persist(messageMapper.messageDtoToMessage(messageDto));
        template.convertAndSendToUser(messageDto.getTo().getUsername()
                , "/user/chat", messageDto);
    }

    @GetMapping("/activation/{code}")
    public ResponseEntity<MessageDto> activate(@PathVariable String code) {
        boolean isActivated = userService.activateUser(code);
        String message;
        if (isActivated) {
            message = "User successfully activated";
        } else
            message = "Activation code is not found";
        return ResponseEntity.ok (messageMapper.activationMessageToMessageDto(message));
    }
}
