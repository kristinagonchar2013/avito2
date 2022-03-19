package com.amr.project.webapp.controller;

import com.amr.project.converter.ChatMapper;
import com.amr.project.converter.MessageMapper;
import com.amr.project.model.dto.ChatDto;
import com.amr.project.model.dto.MessageDto;
import com.amr.project.model.entity.Chat;
import com.amr.project.model.entity.Message;
import com.amr.project.service.abstracts.ChatService;
import com.amr.project.service.abstracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class ChatController {

    private final ChatService chatService;
    private final UserService userService;
    private final ChatMapper chatMapper;
    private final MessageMapper messageMapper;

    @Autowired
    public ChatController(ChatService chatService, UserService userService, ChatMapper chatMapper, MessageMapper messageMapper) {
        this.chatService = chatService;
        this.userService = userService;
        this.chatMapper = chatMapper;
        this.messageMapper = messageMapper;
    }

    @GetMapping("/chat/{id}")
    public ResponseEntity<ChatDto> getChat(@PathVariable Long id){
        return ResponseEntity.ok().body(chatMapper.chatToChatDto(chatService.findById(id)));
    }

    @GetMapping("/user/{id}/chats")
    public ResponseEntity<Set<ChatDto>> getAllUsersChats(@PathVariable Long id) {
        Set<Chat> chats = userService.findById(id).getChats();
        return ResponseEntity.ok().body(chatMapper.setOfChatToChatDto(chats));
    }

    @GetMapping("/chat/{id}/messages")
    public ResponseEntity<List<MessageDto>> getAllMessages(@PathVariable("id") Long id) {
        List<Message> list = chatService.findById(id).getMessages();
        return ResponseEntity.status(HttpStatus.OK).body(messageMapper.listOfMessageToMessageDto(list));
    }

    @PostMapping("/user/{id}/chat")
    public ResponseEntity<ChatDto> createChat(@RequestBody ChatDto chatDto) {
        chatService.persist(chatMapper.chatDtoToChat(chatDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(chatDto);
    }

    @DeleteMapping("/chat/{id}")
    public ResponseEntity deleteChatById(@PathVariable Long id) {
        chatService.delete(chatService.findById(id));
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
