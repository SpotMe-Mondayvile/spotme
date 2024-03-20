package com.mts.spotmerest.controllers;

import com.mts.spotmerest.models.Match;
import com.mts.spotmerest.services.MatchService;
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
@RequestMapping(path = "api/v1/match")
public class MatchController {
    private final MatchService matchService;
    private final SpotService spotService;
   @Autowired
    public MatchController(MatchService matchService, SpotService spotService){
        this.matchService= matchService;
       this.spotService = spotService;
   }

    @GetMapping
    public String printHello(){
       return "User Web Controller";
    }
    @GetMapping(path="/all")
    public List<Match> getUsers(){
        return matchService.getMatches();
    }

    @GetMapping(path= "by/user/{userId}")
    public List<Match> getSpotByUserID(@PathVariable("userId") Long id){
        return spotService.getSpotMatchesByUserID(id);
    }
    @GetMapping(path= "by/spot/{spotId}")
    public List<Match> getSpotMatchesByID(@PathVariable("spotId") Long id){
        return spotService.getSpotMatchesByID(id);
    }

    @GetMapping(path = "id/{matchId}")
    public Optional<Match> getMatchByID(@PathVariable("matchId")Long id){
       return matchService.getMatchByID(id);
    }

    @PostMapping(path="/add")
    public void newMatch(@RequestBody Match match){
       System.out.println(match);
       matchService.addNewMatch(match);
    }

    @DeleteMapping(path= "/{match_id}")
    public void deleteMatch(@PathVariable("match_id") Long id){
        matchService.deleteMatch(id);
    }
}
