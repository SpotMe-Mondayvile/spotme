package com.mts.spotmerest.controllers;

import com.mts.spotmerest.models.Match;
import com.mts.spotmerest.models.User;
import com.mts.spotmerest.services.MatchService;
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
@RequestMapping(path = "api/v1/match")
public class MatchController {
    private final MatchService matchService;
   @Autowired
    public MatchController(MatchService matchService){
        this.matchService= matchService;
    }

    @GetMapping
    public String printHello(){
       return "User Web Controller";
    }
    @GetMapping(path="/all")
    public List<Match> getUsers(){
        return matchService.getMatches();
    }

    @PostMapping(path="/add")
    public void newMatch(@RequestBody Match match){
       System.out.println(match);
       matchService.addNewMatch(match);
    }

    @DeleteMapping(path= "/{UserId}")
    public void deleteMatch(@PathVariable("UserId") Long id){
        matchService.deleteMatch(id);
    }
}
