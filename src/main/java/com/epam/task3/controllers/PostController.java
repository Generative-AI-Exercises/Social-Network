package com.epam.task3.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.task3.entities.Post;
import com.epam.task3.services.PostService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {
	
    private final PostService postService;
    
    @PostMapping("/{userId}")
    public ResponseEntity<Post> createPost(@RequestBody Post post, @PathVariable Long userId) {
        Post savedPost = postService.createPost(post, userId);
        return new ResponseEntity<>(savedPost, HttpStatus.CREATED);
    }

    @PostMapping("/{postId}/like/{userId}")
    public ResponseEntity<String> likePost(@PathVariable Long postId, @PathVariable Long userId) {
        postService.likePost(userId, postId);
        return new ResponseEntity<>("User " + userId + " liked Post " + postId, HttpStatus.OK);
    }

}
