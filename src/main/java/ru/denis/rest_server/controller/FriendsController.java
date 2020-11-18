package ru.denis.rest_server.controller;

import org.springframework.web.bind.annotation.*;
import ru.denis.rest_server.model.Friends;
import ru.denis.rest_server.service.FriendsService;


import java.util.List;

@RestController
@RequestMapping("friends")
public class FriendsController {
    private final FriendsService friendsService;

    public FriendsController(FriendsService friendsService) {
        this.friendsService = friendsService;
    }

    @GetMapping
    public List<Friends> allFriends() {
        return friendsService.findAll();
    }

    @GetMapping("/{id}")
    public Friends FriendById(@PathVariable("id") Long id) {
        return friendsService.findById(id);
    }

    @PostMapping
    public void addFriend(@RequestBody Friends friends) {
        friendsService.save(friends);
    }

    @PutMapping("/{id}")
    public void updateFriendById(@PathVariable("id") Long id, @RequestBody Friends updateFriend) {
        Friends friend = friendsService.findById(id);
        friend.setUser1(updateFriend.getUser1());
        friend.setUser2(updateFriend.getUser2());
        friendsService.update(friend);
    }

    @PutMapping
    public void updateFriend(@RequestBody Friends friends) {
        friendsService.update(friends);
    }

    @DeleteMapping("/{id}")
    public void deleteFriend(@PathVariable("id") Long id) {
        friendsService.deleteById(id);
    }
}
