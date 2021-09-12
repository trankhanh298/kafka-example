package com.khan.user.service;

import com.khan.user.entity.UserEntity;
import com.khan.user.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    // @Value("${spring.kafka.topic.userCreated}")
    // private String USER_CREATED_TOPIC;

    private UserRepository userRepository;
    // private Sender sender;

    @Autowired
    // UserService(UserRepository userRepository, Sender sender) {
    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        // this.sender = sender;
    }

    public UserEntity registerUser(UserEntity input) {
        UserEntity createdUser = userRepository.save(input);
        // sender.send(USER_CREATED_TOPIC, createdUser);
        return createdUser;
    }

    public Iterable<UserEntity> findAll() {
        return userRepository.findAll();
    }
}
