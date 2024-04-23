package com.mts.spotmerest.controllers;



import com.mts.spotmerest.models.Routine;
import com.mts.spotmerest.services.RoutineService;
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
@RequestMapping(path = "api/v1/routine")
public class RoutineController {

    private final RoutineService routineService;
    @Autowired
    public RoutineController(RoutineService routineService) {
        this.routineService = routineService;
    }



}