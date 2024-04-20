package com.mts.spotmerest.services.friendships;

import com.mts.spotmerest.mappers.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;

public class FriendRequestService {

    @Autowired
    private final UserDAO userDAO;


    @Autowired
    public FriendRequestService(UserDAO userDAO){
        this.userDAO = userDAO;
    }
}
