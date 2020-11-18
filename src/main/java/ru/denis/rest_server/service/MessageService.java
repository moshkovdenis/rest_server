package ru.denis.rest_server.service;

import org.springframework.stereotype.Service;
import ru.denis.rest_server.model.Message;
import ru.denis.rest_server.repository.MessageRepository;

import java.util.Date;
import java.util.List;

@Service("MessageService")
public class MessageService implements CrudService<Message> {
    private final MessageRepository repository;

    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Message> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Message message) {
        repository.save(message);
    }

    @Override
    public Message findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void update(Message message) {
        message.setTime_creation(new Date());
        repository.save(message);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
