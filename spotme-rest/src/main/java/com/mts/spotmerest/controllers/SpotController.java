package com.mts.spotmerest.controllers;

import com.mts.spotmerest.models.Spot;
import com.mts.spotmerest.models.User;
import com.mts.spotmerest.services.SpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@RestController
@RequestMapping(path = "api/v1/spot")
public class SpotController {
    private final SpotService spotService;
   @Autowired
    public SpotController(SpotService spotService){
        this.spotService= spotService;
    }

    @GetMapping
    public String printHello(){
       return "Spot Web Controller";
    }
    @GetMapping(path="/all")
    public List<Spot> getSpots(){
        return spotService.getSpots();
    }

    @PostMapping(path="/add")
    public void newSpot(@RequestBody Spot spot){
       System.out.println(spot);
       spotService.addNewSpot(spot);
    }

    @DeleteMapping(path= "/{spotId}")
    public void deleteSpot(@PathVariable("spotId") Long id){
        spotService.deleteSpot(id);
    }
}
