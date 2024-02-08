package com.mts.spotmerest.services;

import com.mts.spotmerest.mappers.UserDOA;
import com.mts.spotmerest.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserDOA userDOA;

    @Autowired
    public UserService(UserDOA userDOA){
        this.userDOA = userDOA;
    }
    public List<User> getUsers(){

        return userDOA.findAll();
    }
}
