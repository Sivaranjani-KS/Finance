package com.example.LearnSpringBoot.controller;

import com.example.LearnSpringBoot.model.User;
import com.example.LearnSpringBoot.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    // ✅ CREATE with validation
    @PostMapping
    public User create(@Valid @RequestBody User user) {
        return service.create(user);
    }

    // ✅ READ all users
    @GetMapping
    public List<User> getAll() {
        return service.getAll();
    }
}