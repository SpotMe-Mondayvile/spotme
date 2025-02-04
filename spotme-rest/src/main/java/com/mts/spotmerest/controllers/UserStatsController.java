package com.mts.spotmerest.controllers;

import com.mts.spotmerest.auth.DataFilter;
import com.mts.spotmerest.models.Spot;
import com.mts.spotmerest.models.UserStats;
import com.mts.spotmerest.services.SpotService;
import com.mts.spotmerest.services.UserService;
import com.mts.spotmerest.services.UserStatsService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@RestController
@RequestMapping(path = "api/v1/userStat")
@SecurityRequirement(name = "JWT")
public class UserStatsController {
    private final DataFilter dataFilter;
    private final SpotService spotService;
    private final UserService userService;
    private final UserStatsService userStatsService;

    @Autowired
    public UserStatsController(UserStatsService userStatsService,UserService userService,DataFilter dataFilter,SpotService spotService){
        this.spotService= spotService;
        this.dataFilter=dataFilter;
        this.userStatsService=userStatsService;
        this.userService= userService;
    }


    @GetMapping(path="stats")
    public Optional<UserStats> getSpots(Principal principal){
        return userStatsService.getUserStatsByUserEmail(principal.getName());
    }

    @GetMapping(path= "id/{userStatsId}")
    public Optional<UserStats> getUserStatsByID(@PathVariable("userStatsId") Long id, Principal principal){
        Optional<UserStats> validatedUserStats = Optional.empty();
        Optional<UserStats> requestedUserStats = userStatsService.getUserStats(id);
        Long owner = requestedUserStats.orElseThrow().getUserId();
//        if(dataFilter.isUser(principal,owner)){
//            validatedUserStats=userStatsService.getUserStats(id);
//        }
        validatedUserStats=userStatsService.getUserStats(id);
        return validatedUserStats ;
    }

    @GetMapping(path= "id/{userId}")
    public Optional<UserStats> getUserStatsByUserID(@PathVariable("userId") Long id, Principal principal){
        Long requester = dataFilter.getPrincipalId(principal);
        Optional<UserStats> validatedUserStats = Optional.empty();
        Optional<UserStats> requestedUserStats = userStatsService.getUserStatsByUserID(requester);
        Long owner = requestedUserStats.orElseThrow().getUserId();
//            if(dataFilter.isUser(principal,owner)){
//                validatedUserStats=userStatsService.getUserStats(id);
//            }
        validatedUserStats=userStatsService.getUserStats(id);
        return validatedUserStats;
    }

    @PostMapping(path="/add")
    public void newSpot(@RequestBody UserStats userStats, Principal principal){
        System.out.println(userStats);
        if(dataFilter.isUser(principal,userStats.getUserId())){
            userStatsService.addNewUserStats(userStats);
        }
    }

    @DeleteMapping(path= "/{userStatsId}")
    public void deleteSpot(@PathVariable("userStatsId") Long id,Principal principal){
        Optional<Spot> newSpot = Optional.empty();
        Long owner = spotService.getSpot(id).orElseThrow().getUserId();
        if(dataFilter.isUser(principal,owner)){
            spotService.deleteSpot(id);
        }
    }
}
