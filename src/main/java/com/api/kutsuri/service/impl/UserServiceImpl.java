package com.api.kutsuri.service.impl;

import java.util.List;
import java.util.Optional;

import com.api.kutsuri.model.User;
import com.api.kutsuri.repository.UserRepository;
import com.api.kutsuri.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(int id, User userDetails) {
        User user = userRepository.getById(id);

        user.setName(userDetails.getName());
        user.setPassword(userDetails.getPassword());

        return userRepository.save(user);
    }
    
}
