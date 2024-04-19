package com.mts.spotmerest.controllers;

import com.mts.spotmerest.auth.DataFilter;
import com.mts.spotmerest.models.User;
import com.mts.spotmerest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.security.Principal;
import java.util.List;
import java.util.Objects;
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

    private final DataFilter dataFilter = new DataFilter();
    @GetMapping
    public String printHello(){
       return "User Web Controller";
    }

    @GetMapping(path="/all")
    public List<User> getUsers(@PathVariable("user_id") Long userId, Principal principal) throws Exception{
        // test if userId is current principal or principal is an ADMIN
        Optional<User> user = userService.getUserByEmail(principal.getName());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userService.getUsers(authentication);
    }

    //    @GetMapping(path="/emails")
    //    public List<String> getEmails(){
    //        return userService.getEmails();
    //    }

    @GetMapping(path="/email/{uEmail}")
    public String getEmail(@PathVariable("uEmail")String email){
        return userService.getEmail(email);
    }


    @GetMapping(path = "/{user_id}")
    public Optional<User> getUserInfo(@PathVariable("user_id") Long userId, Principal principal) throws Exception {
        // test if userId is current principal or principal is an ADMIN
        Optional<User> out= Optional.empty();
        if(dataFilter.isUser(principal,userService)){
            out =userService.getUserByID(userId);
        }
        return out;
    }

    @GetMapping(path = "/getinfo")
    public Optional<User> getUserInfo(Principal principal) throws Exception {
        // test if userId is current principal or principal is an ADMIN
        Optional<User> out= Optional.empty();
        if(dataFilter.isUser(principal,userService)){
            out =userService.getUserByEmail(principal.getName());
        }
        return out;
    }

    @DeleteMapping(path= "/{UserId}")
    public void deleteUser(@PathVariable("UserId") Long id){
        userService.deleteUser(id);
    }


    //// Admin controls

}
