package com.mts.spotmerest.controllers;

import com.mts.spotmerest.models.User;
import com.mts.spotmerest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public String printHello(){
       return "User Web Controller";
    }
    @GetMapping(path="/all")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping(path="/add")
    public void newUser(@RequestBody User user){
       System.out.println(user);
       userService.addNewUser(user);
    }

    @DeleteMapping(path= "/{UserId}")
    public void deleteUser(@PathVariable("UserId") Long id){
        userService.deleteUser(id);
    }

    @GetMapping(path= "/{UserId}")
    public Optional<User> getUser(@PathVariable("UserId") Long id){
       return userService.getUser(id);
    }
}
