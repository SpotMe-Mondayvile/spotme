package com.mts.spotmerest.controllers;

import com.mts.spotmerest.models.User;
import com.mts.spotmerest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Configuration
@EnableAutoConfiguration
@ComponentScan
@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {
    private final UserService userService;
   @Autowired
    public UserController(UserService userService){
        this.userService= userService;
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

}
