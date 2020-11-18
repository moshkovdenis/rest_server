package ru.denis.rest_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.denis.rest_server.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
