package ru.denis.rest_server.service;

import org.springframework.stereotype.Service;
import ru.denis.rest_server.model.Friends;
import ru.denis.rest_server.repository.FriendsRepository;

import java.util.List;

@Service("FriendsService")
public class FriendsService implements CrudService<Friends> {
    private final FriendsRepository repository;

    public FriendsService(FriendsRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Friends> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Friends friends) {
        repository.save(friends);
    }

    @Override
    public Friends findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void update(Friends friends) {
        repository.save(friends);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
