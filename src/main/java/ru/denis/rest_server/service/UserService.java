package ru.denis.rest_server.service;

import org.springframework.stereotype.Service;
import ru.denis.rest_server.model.User;
import ru.denis.rest_server.repository.UserRepository;

import java.util.List;

@Service("UserService")
public class UserService implements CrudService<User> {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void update(User user) {
        repository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
