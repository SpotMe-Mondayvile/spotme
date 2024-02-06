package com.mts.spotmerest.services;

import com.mts.spotmerest.models.User;

import java.util.List;

public class UserService {


    public List<User> getUsers(){
        return List.of(
                new User(
                        214234L,
                        "Magus",
                        25,
                        "Man",
                        "Black"),
                new User(
                        214235L,
                        "Prince",
                        23,
                        "Man",
                        "Black"));
    }
}
