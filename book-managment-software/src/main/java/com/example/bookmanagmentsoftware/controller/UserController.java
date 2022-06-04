package com.example.bookmanagmentsoftware.controller;


import com.example.bookmanagmentsoftware.model.User;
import com.example.bookmanagmentsoftware.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    Logger logger = LoggerFactory.getLogger(BookController.class);
    @GetMapping
    public ResponseEntity getUser(){
        return ResponseEntity.status(200).body(userService.getAllUser());
    }
    @PostMapping
    public ResponseEntity postUserBank(@RequestBody @Valid User user) throws IllegalAccessException {
        userService.addUser(user);
        logger.info("new user added");
        return ResponseEntity.status(200).body("User Added!!");
    }
    
}
