package ru.denis.rest_server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.denis.rest_server.model.Community;
import ru.denis.rest_server.repository.CommunityRepository;

import java.util.List;

@Service("CommunityService")
public class CommunityService implements CrudService<Community> {
    private final CommunityRepository repository;

    public CommunityService(CommunityRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Community> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Community community) {
        repository.save(community);
    }

    @Override
    public Community findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void update(Community community) {
        repository.save(community);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
