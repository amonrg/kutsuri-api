package com.api.kutsuri.service;

import java.util.List;
import java.util.Optional;

import com.api.kutsuri.model.User;

public interface UserService {
    User add(User user);
    List<User> getAll();
    Optional<User> getUserById(int id);
    void deleteUserById(int id);
    User updateUser(int id, User userDetails);
}
