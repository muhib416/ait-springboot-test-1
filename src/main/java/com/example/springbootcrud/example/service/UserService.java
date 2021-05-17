package com.example.springbootcrud.example.service;

import com.example.springbootcrud.example.entity.User;
import com.example.springbootcrud.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return  userRepository.save(user);
    }

    public List<User> getUser() {
        return userRepository.findAll();
    }

    public List<User> getUserByName(String name) {
        return userRepository.findByName(name);
    }
}
