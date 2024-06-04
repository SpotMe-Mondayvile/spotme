package com.mts.spotmerest.services.friendships;

import com.mts.spotmerest.mappers.UserDAO;
import com.mts.spotmerest.mappers.friendships.FriendRequestDAO;
import com.mts.spotmerest.models.friendships.FriendRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FriendRequestService {

    @Autowired
    private final UserDAO userDAO;

    private final FriendRequestDAO friendRequestDAO;


    @Autowired
    public FriendRequestService(UserDAO userDAO, FriendRequestDAO friendRequestDAO){
        this.userDAO = userDAO;
        this.friendRequestDAO = friendRequestDAO;
    }

    public List<Optional<FriendRequest>> outGoingRequests(Long targetId){

        return friendRequestDAO.findAllByTargetUser(targetId);
    }

    public List<Optional<FriendRequest>> incomingRequests(Long targetId){

        return friendRequestDAO.findAllByTargetUser(targetId);
    }

    public Optional<FriendRequest> getFriendRequest(Long id) {
        return friendRequestDAO.findById(id);
    }
}
