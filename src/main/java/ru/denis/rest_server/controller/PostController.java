package ru.denis.rest_server.controller;

import org.springframework.web.bind.annotation.*;
import ru.denis.rest_server.model.Post;
import ru.denis.rest_server.service.PostService;

import java.util.List;

@RestController
@RequestMapping("post")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> allPosts() {
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public Post postById(@PathVariable("id") Long id) {
        return postService.findById(id);
    }

    @PostMapping
    public void addPost(@RequestBody Post post) {
        postService.save(post);
    }

    @PutMapping("/{id}")
    public void updatePostById(@PathVariable("id") Long id, @RequestBody Post updatePost) {
        Post post = postService.findById(id);
        post.setTitle(updatePost.getTitle());
        post.setPost_text(updatePost.getPost_text());
        post.setTag(updatePost.getTag());
        post.setCommunity(updatePost.getCommunity());
        postService.update(post);
    }

    @PutMapping
    public void updatePost(@RequestBody Post post) {
        postService.update(post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable("id") Long id) {
        postService.deleteById(id);
    }
}
