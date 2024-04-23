package com.mts.spotmerest.services.friendships;

import com.mts.spotmerest.mappers.UserDAO;
import com.mts.spotmerest.mappers.friendships.UserFriendsDAO;
import com.mts.spotmerest.models.User;
import com.mts.spotmerest.models.friendships.UserFriends;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserFriendsService {
    private final UserFriendsDAO userFriendsDAO;
    private final UserDAO userDAO;

    @Autowired
    public UserFriendsService(UserFriendsDAO userFriendsDAO, UserDAO userDAO){
        this.userDAO= userDAO;
        this.userFriendsDAO = userFriendsDAO;
    }

    public void addUserFriends(Long userId,Long friendId) {
        UserFriends newFriendship = new UserFriends();
        newFriendship.setUser(userDAO.findById(userId).orElseThrow());
        newFriendship.setFriendId(friendId);
        userFriendsDAO.save(newFriendship);
    }

    public void removeFriend(Long friendShipId){
        Optional<UserFriends> friendShip= userFriendsDAO.findById(friendShipId);
        if(friendShip.isPresent()){
            userFriendsDAO.deleteById(friendShipId);
        }
    }



}
