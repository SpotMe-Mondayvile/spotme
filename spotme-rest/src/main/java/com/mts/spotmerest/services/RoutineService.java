package com.mts.spotmerest.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mts.spotmerest.models.Routine;
import com.mts.spotmerest.mappers.RoutineDAO;

import java.util.Optional;


@Service
public class RoutineService {
//methods/functionalities to create add, delete, edit, favorite

    private final RoutineDAO routineDAO;

    @Autowired
    public RoutineService(RoutineDAO routineDAO) {
        this.routineDAO = routineDAO;
    }

    //For creation, you're passing in a new model b/c you need a model of what you're adding, comes with own parameters
    public void addNewRoutine(Routine routine) {

        routineDAO.save(routine);
    }

    //delete user, select by uniqueID

    public void deleteRoutine(Routine routine) {
        // Check if the routine exists,

        Optional<Routine> optionalRoutine = routineDAO.findByName(routine.getRoutineName());

        if (optionalRoutine.isPresent()) {
            // if Routine exists, delete BY NAME
            routineDAO.deleteByName(routine.getRoutineName());
        } else {
            // Handle the case where the routine does not exist, throw an exception, log, or handle accordingly
            throw new IllegalArgumentException("Routine not found!");
        }
    }


    public void editRoutine(Routine routine) {

        Optional<Routine> original = routineDAO.findByName(routine.getRoutineName());
        Routine newRoutine = original.orElseThrow().editRoutine(routine);
        routineDAO.deleteById(original.orElseThrow().getRoutineId());
        routine = newRoutine; //Added after office hours with Magus
        routineDAO.save(routine);
    }


}
