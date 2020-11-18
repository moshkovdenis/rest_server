package ru.denis.rest_server.service;

import org.springframework.stereotype.Service;
import ru.denis.rest_server.model.Post;
import ru.denis.rest_server.repository.PostRepository;

import java.util.List;

@Service("PostService")
public class PostService implements CrudService<Post> {
    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Post> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Post post) {
        repository.save(post);
    }

    @Override
    public Post findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void update(Post post) {
        repository.save(post);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
