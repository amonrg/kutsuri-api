package com.api.kutsuri.controller;

import java.util.List;

import javax.validation.Valid;

import com.api.kutsuri.model.User;
import com.api.kutsuri.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @PostMapping("/users")
    public User addOrder(@Valid @RequestBody User user) {
        return userService.add(user);
    }

    @GetMapping("/users/{id}")
    public User getOrderById(@PathVariable(name = "id") int id) {
        return userService.getUserById(id).orElseThrow();
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable(name = "id") int id, 
                           @Valid @RequestBody User userDetails) {
        return userService.updateUser(id, userDetails);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable(name = "id") int id) {        
        userService.deleteUserById(id);
        return ResponseEntity.ok().build();
    }
}
