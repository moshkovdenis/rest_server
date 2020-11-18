package ru.denis.rest_server.controller;

import org.springframework.web.bind.annotation.*;
import ru.denis.rest_server.model.Message;
import ru.denis.rest_server.service.MessageService;

import java.util.List;

@RestController
@RequestMapping("message")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public List<Message> allMessages() {
        return messageService.findAll();
    }

    @GetMapping("/{id}")
    public Message messageById(@PathVariable("id") Long id) {
        return messageService.findById(id);
    }

    @PostMapping
    public void addMessage(@RequestBody Message message) {
        messageService.save(message);
    }

    @PutMapping("/{id}")
    public void updateMessageById(@PathVariable("id") Long id, @RequestBody Message updateMessage) {
        Message message = messageService.findById(id);
        message.setUser1(updateMessage.getUser1());
        message.setUser2(updateMessage.getUser2());
        message.setChat(updateMessage.getChat());
        messageService.update(message);
    }

    @PutMapping
    public void updateMessage(@RequestBody Message message) {
        messageService.update(message);
    }

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable("id") Long id) {
        messageService.deleteById(id);
    }
}
