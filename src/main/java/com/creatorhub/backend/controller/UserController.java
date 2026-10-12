package com.creatorhub.backend.controller;

import com.creatorhub.backend.entity.User;
import com.creatorhub.backend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    @PutMapping("/{id}")
    public User updateUser(
            @PathVariable Long id,
            @Valid @RequestBody User user)  {

        return userService.updateUser(id, user);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    // Get logged-in user's profile
    @GetMapping("/me")
    public User getMyProfile(Authentication authentication) {
        return userService.getMyProfile(authentication.getName());
    }

    // Update logged-in user's profile
    @PutMapping("/me")
    public User updateMyProfile(
            Authentication authentication,
            @RequestBody User updatedUser) {

        return userService.updateMyProfile(
                authentication.getName(), updatedUser);
    }

}