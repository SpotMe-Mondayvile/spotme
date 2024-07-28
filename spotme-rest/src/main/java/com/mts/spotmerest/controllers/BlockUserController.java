package com.mts.spotmerest.controllers;

import com.mts.spotmerest.auth.DataFilter;
import com.mts.spotmerest.models.User;
import com.mts.spotmerest.models.friendships.BlockUser;
import com.mts.spotmerest.services.UserService;
import com.mts.spotmerest.services.friendships.BlockUserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;
import java.util.Set;

@Controller
@Configuration
@EnableAutoConfiguration
@ComponentScan
@RestController
@SecurityRequirement(name = "JWT")
@RequestMapping(path = "api/v1/friends/blockUsers")
public class BlockUserController {
    private final DataFilter dataFilter;
    private final BlockUserService blockUserService;
    private final UserService userService;

    public BlockUserController(DataFilter dataFilter, BlockUserService blockUserService, UserService userService){
        this.dataFilter = dataFilter;
        this.blockUserService = blockUserService;
        this.userService = userService;
    }

    @GetMapping(path = "/all")
    public Set<Optional<BlockUser>> getBlockedUsers(Principal principal){
        Optional<User> out=userService.getUserByEmail(principal.getName());
        return this.blockUserService.allBlockedUsers(out.orElseThrow().getId());
    }

    @GetMapping(path = "/userBlockedBy")
    public Set<Optional<BlockUser>> userBlockedBy(Principal principal){
        Optional<User> out=userService.getUserByEmail(principal.getName());
        return this.blockUserService.allUsersBlockedBy(out.orElseThrow().getId());
    }


    //not sure how to execute
    @PostMapping(path ="/add")
    public void addBlockUser(@RequestBody Long userId, Long targetUserId){
        BlockUser b = new BlockUser(targetUserId, userId);
        blockUserService.createBlockUser(b);
    }

    /*
    not really sure how to execute this either
    @DeleteMapping(path = "/delete/{id}")
     */

}
