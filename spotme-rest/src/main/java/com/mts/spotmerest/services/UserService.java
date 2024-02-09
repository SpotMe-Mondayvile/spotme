package com.mts.spotmerest.services;

import com.mts.spotmerest.mappers.UserDOA;
import com.mts.spotmerest.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void addNewUser(User user) {
        Optional<User> userByUserName= userDOA
                .findUserByUserName(user.getUsername());
        if(userByUserName.isPresent()){
            throw new IllegalStateException("Email taken");
        }
        userDOA.save(user);
    }

    public void deleteUser(Long id) {
     boolean exists =userDOA.existsById(id);
     if(!exists){
         throw new IllegalStateException("User with id "+ id+ "does not exist");
     }else{
         userDOA.deleteById(id);
        }
     }

}
