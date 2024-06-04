package com.mts.spotmerest.controllers;

import com.mts.spotmerest.auth.DataFilter;
import com.mts.spotmerest.mappers.friendships.FriendRequestDAO;
import com.mts.spotmerest.models.friendships.FriendRequest;
import com.mts.spotmerest.models.friendships.UserFriends;
import com.mts.spotmerest.services.friendships.FriendRequestService;
import com.mts.spotmerest.services.friendships.UserFriendsService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@RestController
@SecurityRequirement(name = "JWT")
@RequestMapping(path = "api/v1/friends")
public class FriendshipController {
    private final DataFilter dataFilter;
    private final UserFriendsService userFriendsService;
    private final FriendRequestService friendRequestService;


    @Autowired
    public FriendshipController(DataFilter dataFilter, UserFriendsService userFriendsService, FriendRequestService friendRequestService) {
        this.userFriendsService= userFriendsService;
        this.dataFilter= dataFilter;
        this.friendRequestService= friendRequestService;
    }

    @PostMapping(value = "/add")
    public void userFriendRequest(@RequestBody FriendRequest friendRequest, Principal principal) {
        Long userId = dataFilter.getPrincipalId(principal);
        if(friendRequest.getStatus().equals("CONFIRMED")) {
            userFriendsService.addUserFriends(userId, friendRequest.getCreator());
        }
    }

    @PostMapping(value = "/send_request")
    public void sendUserFriendRequest(@RequestBody FriendRequest friendRequest, Principal principal) {
        Long userId = dataFilter.getPrincipalId(principal);

    }

    @PostMapping(value = "/accept/{id}")
    public void acceptFriendRequest(@PathVariable("{id}") Long id, Principal principal) {
        Long userId = dataFilter.getPrincipalId(principal);
        FriendRequest friendRequest = friendRequestService.getFriendRequest(id).orElseThrow();
        if(friendRequest.getStatus().equals("CONFIRMED")) {
            userFriendsService.addUserFriends(userId, friendRequest.getCreator());
        }
    }


    @DeleteMapping(value = "/delete/{id}")
    public void userFriendRequest(@PathVariable("{id}") Long id, Principal principal) {
        Long userId = dataFilter.getPrincipalId(principal);
        userFriendsService.removeFriend(id);
    }

    @GetMapping(path="/getUserFriendList")
    public List<Optional<UserFriends>> getUserFriendList(Principal principal){
        Long userId = dataFilter.getPrincipalId(principal);
        return this.userFriendsService.getUserFriendsList(userId);
    }



//    @GetMapping(path="/getUserFriendList")
//    public ResponseEntity<Map<String, Object>> getUserFriendList(@RequestBody UserFriendsListRequestEntity userFriendsListRequestEntity) {
//        return this.userFriendsService.getUserFriendsList(userFriendsListRequestEntity);
//    }
//
//    @GetMapping(path= "/getCommonUserFriends")
//    public ResponseEntity<Map<String, Object>> getCommonUserFriends(@RequestBody UserFriendsRequestEntity userFriendsRequestEntity) {
//        return this.userFriendsService.getCommonUserFriends(userFriendsRequestEntity);
//    }
//
//    @PostMapping(path = "/subscribeUserRequest")
//    public ResponseEntity<Map<String, Object>> subscribeUserRequest(@RequestBody SubscribeUserRequestEntity subscribeUserRequestEntity) {
//        return this.subscribeUserService.addSubscribeUser(subscribeUserRequestEntity);
//    }
//
//    @PostMapping(path = "/blockUserRequest")
//    public ResponseEntity<Map<String, Object>> blockUserRequest(@RequestBody BlockUserRequestEntity blockUserRequestEntity) {
//        return this.blockUserService.addBlockUser(blockUserRequestEntity);
}
