package com.mts.spotmerest.services;

import com.mts.spotmerest.mappers.UserDAO;
import com.mts.spotmerest.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    public List<User> getUsers(){

        return userDAO.findAll();
    }

    public void addNewUser(User user) {
        Optional<User> userByUserName= userDAO
                .findUserByUserName(user.getUsername());
        if(userByUserName.isPresent()){
            throw new IllegalStateException("Email taken");
        }
        userDAO.save(user);
    }

    public void deleteUser(Long id) {
     boolean exists = userDAO.existsById(id);
     if(!exists){
         throw new IllegalStateException("User with id "+ id+ "does not exist");
     }else{
         userDAO.deleteById(id);
        }
     }

    public void getUser(Long id) {
        userDAO.findById(id);
    }
}
