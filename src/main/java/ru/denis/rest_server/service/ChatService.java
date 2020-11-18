package ru.denis.rest_server.service;

import org.springframework.stereotype.Service;
import ru.denis.rest_server.model.Chat;
import ru.denis.rest_server.repository.ChatRepository;

import java.util.Date;
import java.util.List;

@Service("ChatService")
public class ChatService implements CrudService<Chat> {
    private final ChatRepository chatRepository;

    public ChatService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @Override
    public List<Chat> findAll() {
        return chatRepository.findAll();
    }

    @Override
    public void save(Chat chat) {
        chat.setTime_creation(new Date());
        chatRepository.save(chat);
    }

    @Override
    public Chat findById(Long id) {
        return chatRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Chat chat) {
        chatRepository.save(chat);
    }

    @Override
    public void deleteById(Long id) {

    }
}
