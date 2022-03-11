package com.amr.project.service.datainit;

import com.amr.project.model.entity.Message;
import com.amr.project.service.abstracts.ChatService;
import com.amr.project.service.abstracts.MessageService;
import com.amr.project.service.abstracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInit10 {

    private final MessageService messageService;
    private final UserService userService;
    private final ChatService chatService;

    @Autowired
    public DataInit10(MessageService messageService, UserService userService, ChatService chatService) {
        this.messageService = messageService;
        this.userService = userService;
        this.chatService = chatService;
    }

    @PostConstruct
    private void messageDataInit() {
        messageService.persist(Message.builder()
                .chat(chatService.findById(1L))
                .textMessage("Hello")
                .viewed(true)
                .to(userService.findById(1L))
                .from(userService.findById(2L))
                .build());
        messageService.persist(Message.builder()
                .chat(chatService.findById(1L))
                .textMessage("Hello")
                .viewed(true)
                .to(userService.findById(2L))
                .from(userService.findById(1L))
                .build());
        messageService.persist(Message.builder()
                .chat(chatService.findById(1L))
                .textMessage("I want to buy a table")
                .viewed(true)
                .to(userService.findById(1L))
                .from(userService.findById(2L))
                .build());
        messageService.persist(Message.builder()
                .chat(chatService.findById(1L))
                .textMessage("What delivery do you want")
                .viewed(true)
                .to(userService.findById(2L))
                .from(userService.findById(1L))
                .build());
        messageService.persist(Message.builder()
                .chat(chatService.findById(1L))
                .textMessage("Hello")
                .viewed(true)
                .to(userService.findById(1L))
                .from(userService.findById(3L))
                .build());
        messageService.persist(Message.builder()
                .chat(chatService.findById(1L))
                .textMessage("Hello")
                .viewed(true)
                .to(userService.findById(3L))
                .from(userService.findById(1L))
                .build());
        messageService.persist(Message.builder()
                .chat(chatService.findById(1L))
                .textMessage("Hello")
                .viewed(true)
                .to(userService.findById(1L))
                .from(userService.findById(4L))
                .build());
        messageService.persist(Message.builder()
                .chat(chatService.findById(1L))
                .textMessage("Hello")
                .viewed(true)
                .to(userService.findById(4L))
                .from(userService.findById(1L))
                .build());
        messageService.persist(Message.builder()
                .chat(chatService.findById(1L))
                .textMessage("Hello")
                .viewed(true)
                .to(userService.findById(3L))
                .from(userService.findById(4L))
                .build());
        messageService.persist(Message.builder()
                .chat(chatService.findById(1L))
                .textMessage("Hello")
                .viewed(true)
                .to(userService.findById(4L))
                .from(userService.findById(3L))
                .build());
    }
}
