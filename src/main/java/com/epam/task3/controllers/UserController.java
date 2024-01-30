package com.epam.task3.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.epam.task3.entities.User;
import com.epam.task3.services.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
	
    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PostMapping("/{userId}/follow/{targetId}")
    public ResponseEntity<String> followUser(@PathVariable Long userId, @PathVariable Long targetId) {
        userService.followUser(userId, targetId);
        return new ResponseEntity<>("User " + userId + " is now following User " + targetId, HttpStatus.OK);
    }

}
