package ru.denis.rest_server.controller;

import org.springframework.web.bind.annotation.*;
import ru.denis.rest_server.model.Community;
import ru.denis.rest_server.service.CommunityService;

import java.util.List;

@RestController
@RequestMapping("community")
public class CommunityController {
    private final CommunityService communityService;

    public CommunityController(CommunityService communityService) {
        this.communityService = communityService;
    }

    @GetMapping
    public List<Community> allCommunities() {
        return communityService.findAll();
    }

    @GetMapping("/{id}")
    public Community communityById(@PathVariable("id") Long id) {
        return communityService.findById(id);
    }

    @PostMapping
    public void addCommunity(@RequestBody Community community) {
        communityService.save(community);
    }

    @PutMapping("/{id}")
    public void updateCommunityById(@PathVariable("id") Long id, @RequestBody Community updateCommunity) {
        Community community = communityService.findById(id);
        community.setUser(updateCommunity.getUser());
        communityService.update(community);
    }

    @PutMapping
    public void updateCommunity(@RequestBody Community community) {
        communityService.update(community);
    }

    @DeleteMapping("/{id}")
    public void deleteCommunity(@PathVariable("id") Long id) {
        communityService.deleteById(id);
    }
}
