package com.khan.user.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.khan.user.entity.UserEntity;
import com.khan.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(value = "/user-service", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "users")
    public ResponseEntity<Iterable<UserEntity>> getAll() {
        Iterable<UserEntity> all = userService.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "users")
    public ResponseEntity<UserEntity> register(@RequestBody UserEntity input) {
        UserEntity result = userService.registerUser(input);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
