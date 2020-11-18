package ru.denis.rest_server;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.denis.rest_server.model.*;
import ru.denis.rest_server.service.*;

import java.util.Date;

@SpringBootTest
class RestServerApplicationTests {
    User user1 = new User("denis", "java", "sdasd");;
    User user2 = new User("dedsasanis", "java", "sdasd");
    Friends friends = new Friends(user1, user2);
    Chat chat = new Chat(user1, user2, new Date());
    Post post = new Post("title", "text", "tag");
    Community community = new Community(user1);
    Message message = new Message(user1, user2, chat, new Date());

    @Autowired
    UserService userService;
    @Autowired
    FriendsService friendsService;
    @Autowired
    ChatService chatService;
    @Autowired
    PostService postService;
    @Autowired
    CommunityService communityService;
    @Autowired
    MessageService messageService;

    @Test
    void userServiceTest() {
        userService.save(user1);
        userService.save(user2);
        System.out.println(user1);
        user1.setName("newName");
        userService.update(user1);
        System.out.println(user1);
        System.out.println("find ID" + userService.findById(user1.getId()));
        System.out.println(userService.findAll());
        friendsService.save(friends);
        System.out.println(friendsService.findAll());
        chatService.save(chat);
        postService.save(post);
        communityService.save(community);
        messageService.save(message);
    }

    @Test
    void chatServiceTest() {

    }

    @Test
    void messageServiceTest() {

    }

    @Test
    void communityServiceTest() {

    }

    @Test
    void postServiceTest() {

    }
}
