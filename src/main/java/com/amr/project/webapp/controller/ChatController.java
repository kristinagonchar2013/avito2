package com.amr.project.webapp.controller;

import com.amr.project.converter.ChatMapper;
import com.amr.project.converter.MessageMapper;
import com.amr.project.model.dto.ChatDto;
import com.amr.project.model.dto.MessageDto;
import com.amr.project.model.entity.Chat;
import com.amr.project.model.entity.Message;
import com.amr.project.service.abstracts.ChatService;
import com.amr.project.service.abstracts.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Chat Rest Controller", description = "CRUD операции для чата между пользователями")
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
    @Operation(summary = "Вывод чата по его id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK, возвращает один чат")
    })
    public ResponseEntity<ChatDto> getChat(@Parameter(description = "Идентификатор чата") @PathVariable Long id){
        return ResponseEntity.ok().body(chatMapper.chatToChatDto(chatService.findById(id)));
    }

    @GetMapping("/user/{id}/chats")
    @Operation(summary = "Вывод всех чатов определенного юзера (определяется по его id)")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK, возвращает все чаты юзера")
    })
    public ResponseEntity<Set<ChatDto>> getAllUsersChats(@Parameter(description = "Идентификатор пользователя")
                                                             @PathVariable Long id) {
        Set<Chat> chats = userService.findById(id).getChats();
        return ResponseEntity.ok().body(chatMapper.setOfChatToChatDto(chats));
    }

    @GetMapping("/chat/{id}/messages")
    @Operation(summary = "Вывод всех сообщений определенного чата (определяется по его id)")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK, возвращает список сообщений из чата")
    })
    public ResponseEntity<List<MessageDto>> getAllMessages(@Parameter(description = "Идентификатор чата")
                                                               @PathVariable Long id) {
        List<Message> list = chatService.findById(id).getMessages();
        return ResponseEntity.status(HttpStatus.OK).body(messageMapper.listOfMessageToMessageDto(list));
    }

    @PostMapping("/user/{id}/chat")
    @Operation(summary = "Создание чата для определенного юзера (определяется по его id)")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "CREATED, возвращает созданный чат")
    })
    public ResponseEntity<ChatDto> createChat(@RequestBody ChatDto chatDto) {
        chatService.persist(chatMapper.chatDtoToChat(chatDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(chatDto);
    }

    @DeleteMapping("/chat/{id}")
    @Operation(summary = "Удаление чата по его id)")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK, только статус")
    })
    public ResponseEntity deleteChatById(@Parameter(description = "Идентификатор чата") @PathVariable Long id) {
        chatService.delete(chatService.findById(id));
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
