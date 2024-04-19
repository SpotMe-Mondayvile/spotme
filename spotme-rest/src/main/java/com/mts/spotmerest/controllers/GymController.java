package com.mts.spotmerest.controllers;

import com.mts.spotmerest.auth.DataFilter;
import com.mts.spotmerest.models.Gym;
import com.mts.spotmerest.models.Gym;
import com.mts.spotmerest.services.GymService;
import com.mts.spotmerest.services.GymService;
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
@RequestMapping(path = "api/v1/gym")
public class GymController {
    private final DataFilter dataFilter;
    private final GymService gymService;

    @Autowired
    public GymController(GymService gymService,DataFilter dataFilter){
        this.gymService= gymService;
        this.dataFilter=dataFilter;
    }

    @GetMapping
    public String printHello(){
        return "Gym Web Controller";
    }

    @GetMapping(path="all")
    public List<Optional<Gym>> getGyms(Principal principal){
        return gymService.findA(principal.getName());
    }

    @GetMapping(path= "id/{gymId}")
    public Optional<Gym> getGymByID(@PathVariable("gymId") Long id, Principal principal){
        Optional<Gym> validatedGym = Optional.empty();
        Optional<Gym> requestedGym = gymService.getGym(id);
        Long owner = requestedGym.orElseThrow().getUserId();
        if(dataFilter.isUser(principal,owner)){
            validatedGym=gymService.getGym(id);
        }
        return validatedGym ;
    }

    @PostMapping(path="/add")
    public void newGym(@RequestBody Gym gym, Principal principal){
        System.out.println(gym);
        if(dataFilter.isUser(principal,gym.getUserId())){
            gymService.addNewGym(gym);
        }
    }

    @DeleteMapping(path= "/{gym_id}")
    public void deleteGym(@PathVariable("gym_id") Long id,Principal principal){
        Optional<Gym> newGym = Optional.empty();
        Long owner = gymService.getGym(id).orElseThrow().getUserId();
        if(dataFilter.isUser(principal,owner)){
            gymService.deleteGym(id);
        }
    }
}

