package ru.denis.rest_server.controller;

import org.springframework.web.bind.annotation.*;
import ru.denis.rest_server.model.Chat;
import ru.denis.rest_server.service.ChatService;

import java.util.List;

@RestController
@RequestMapping("chat")
public class ChatController {
    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping
    public List<Chat> allChats() {
        return chatService.findAll();
    }

    @GetMapping("/{id}")
    public Chat chatById(@PathVariable("id") Long id) {
        return chatService.findById(id);
    }

    @PostMapping
    public void addChat(@RequestBody Chat chat) {
        chatService.save(chat);
    }

    @PutMapping("/{id}")
    public void updateChatById(@PathVariable("id") Long id, @RequestBody Chat updateChat) {
        Chat chat = chatService.findById(id);
        chat.setUser1(updateChat.getUser1());
        chat.setUser2(updateChat.getUser2());
        chat.setTime_creation(updateChat.getTime_creation());
        chatService.update(chat);
    }

    @PutMapping
    public void updateChat(@RequestBody Chat chat) {
        chatService.update(chat);
    }

    @DeleteMapping("/{id}")
    public void deleteChat(@PathVariable("id") Long id) {
        chatService.deleteById(id);
    }
}
