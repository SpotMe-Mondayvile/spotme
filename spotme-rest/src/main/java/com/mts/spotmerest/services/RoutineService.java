package com.mts.spotmerest.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mts.spotmerest.models.Routine;
import com.mts.spotmerest.mappers.RoutineDAO;


@Service
public class RoutineService {
//methods/functionalities to create add, delete, edit, favorite

    private RoutineDAO routineDAO;

    public RoutineService(RoutineDAO routineDAO) {
        this.routineDAO = routineDAO;
    }

    //For creation, you're passing in a new model b/c you need a model of what you're adding, comes with own parameters
    public void addNewRoutine(Routine routine ){

        routine
    }


}
