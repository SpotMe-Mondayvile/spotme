package com.mts.spotmerest.controllers;

import com.mts.spotmerest.auth.DataFilter;
import com.mts.spotmerest.models.Spot;
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
@RequestMapping(path = "api/v1/spot")
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

    @GetMapping
    public String printHello(){
        return "Spot Web Controller";
    }

    @GetMapping(path="all")
    public List<Optional<Spot>> getSpots(Principal principal){
        return spotService.getSpotMatchesByUserEmail(principal.getName());
    }

    @GetMapping(path= "id/{spotId}")
    public Optional<Spot> getSpotByID(@PathVariable("spotId") Long id, Principal principal){
        Optional<Spot> validatedSpot = Optional.empty();
        Optional<Spot> requestedSpot = spotService.getSpot(id);
        Long owner = requestedSpot.orElseThrow().getUserId();
        if(dataFilter.isUser(principal,owner)){
            validatedSpot=spotService.getSpot(id);
        }
        return validatedSpot ;
    }

    @PostMapping(path="/add")
    public void newSpot(@RequestBody Spot spot, Principal principal){
        System.out.println(spot);
        if(dataFilter.isUser(principal,spot.getUserId())){
            spotService.addNewSpot(spot);
        }
    }

    @DeleteMapping(path= "/{spot_id}")
    public void deleteSpot(@PathVariable("spot_id") Long id,Principal principal){
        Optional<Spot> newSpot = Optional.empty();
        Long owner = spotService.getSpot(id).orElseThrow().getUserId();
        if(dataFilter.isUser(principal,owner)){
            spotService.deleteSpot(id);
        }
    }
}
