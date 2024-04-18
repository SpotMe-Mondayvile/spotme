package com.mts.spotmerest.controllers;

import com.mts.spotmerest.models.Match;
import com.mts.spotmerest.models.Spot;
import com.mts.spotmerest.services.SpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @GetMapping(path="all")
    public List<Spot> getSpots(){
        return spotService.getSpots();
    }

    @GetMapping(path= "id/{spotId}")
    public Optional<Spot> getSpotByID(@PathVariable("spotId") Long id){
        return spotService.getSpot(id);
    }



    @PostMapping(path="/add")
    public void newSpot(@RequestBody Spot spot){
       System.out.println(spot);
       spotService.addNewSpot(spot);
    }

    @DeleteMapping(path= "/{spot_id}")
    public void deleteSpot(@PathVariable("spot_id") Long id){
        spotService.deleteSpot(id);
    }
}
