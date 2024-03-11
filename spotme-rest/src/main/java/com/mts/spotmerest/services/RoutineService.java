package com.mts.spotmerest.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mts.spotmerest.models.Routine;
import com.mts.spotmerest.mappers.RoutineDAO;

import java.util.Optional;


@Service
public class RoutineService {
//methods/functionalities to create add, delete, edit, favorite

    private RoutineDAO routineDAO;

    @Autowired
    public RoutineService(RoutineDAO routineDAO) {
        this.routineDAO = routineDAO;
    }

    //For creation, you're passing in a new model b/c you need a model of what you're adding, comes with own parameters
    public void addNewRoutine(Routine routine ){

            routineDAO.save(routine);
    }

    //delete user, select by uniqueID;

    public void deleteRoutine(Routine routine) {
        // Check if the routine exists, forgot about optional value
        Optional<Routine> optionalRoutine = routineDAO.findById(routine.getUniqueId());

        if (optionalRoutine.isPresent()) {
            // if Routine exists, delete it by ID **CHANGE TO BY NAME
            routineDAO.deleteById(routine.getUniqueId());
        } else {
            // Handle the case where the routine does not exist, throw an exception, log, or handle accordingly
            throw new IllegalArgumentException("Routine not found!");
        }
    }


}
