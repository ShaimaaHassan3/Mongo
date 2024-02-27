package com.springData.springdata.mongodb.services;

import com.springData.springdata.mongodb.entities.User;
import com.springData.springdata.mongodb.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.saveUser(user);
    }

    public User findUserById(String id) {
        return userRepository.findUserById(id);
    }

    public List<User> findAllUsers() {
        return userRepository.findAllUsers();
    }

    public List<User> findUsersByAgeGreaterThan(int age) {
        return userRepository.findUsersByAgeGreaterThan(age);
    }

    public void deleteUser(User user) {
        userRepository.deleteUser(user);
    }
}