package com.amr.project.service.datainit;

import com.amr.project.model.entity.Chat;
import com.amr.project.model.entity.Message;
import com.amr.project.service.abstracts.ChatService;
import com.amr.project.service.abstracts.MessageService;
import com.amr.project.service.abstracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@Component
public class DataInit10 {

    private final ChatService chatService;
    private final UserService userService;

    @Autowired
    public DataInit10(ChatService chatService, UserService userService) {
        this.chatService = chatService;
        this.userService = userService;
    }

    @PostConstruct
    private void chatDataInit() {
        chatService.persist(Chat.builder()
                .member(userService.findById(1L))
                .member(userService.findById(2L))
                .build());
        chatService.persist(Chat.builder()
                .member(userService.findById(1L))
                .member(userService.findById(3L))
                .build());
        chatService.persist(Chat.builder()
                .member(userService.findById(1L))
                .member(userService.findById(4L))
                .build());
        chatService.persist(Chat.builder()
                .member(userService.findById(3L))
                .member(userService.findById(4L))
                .build());
    }
}
