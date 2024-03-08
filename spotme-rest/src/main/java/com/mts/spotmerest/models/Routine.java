package com.mts.spotmerest.models;

import com.mts.spotmerest.models.Exercise;
import com.mts.spotmerest.models.User;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table
public class Routine {  // this Is where we initialize
    @Id
    @SequenceGenerator(
            name="routine_sequence",
            sequenceName="routine_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "routine_sequence"
    )
    private String uniqueId; // for readability, should we lowercase the i//
    private Long userId;
    private String workoutIntensity;
    private List<String> exerciseList;
    private String routineType;



    public Routine (String uniqueId, Long userId, String workoutIntensity, List exerciseList, String routineType) {

        this.uniqueId = uniqueId;
        this.userId = userId;// from user model file
        this.workoutIntensity = workoutIntensity;
        this.exerciseList= exerciseList;
        this.routineType = routineType;

    }

    public Routine() {
    }

    public Routine ( String workoutIntensity, String routineType ) {
        this.workoutIntensity = workoutIntensity;
        this.routineType = routineType;

    }

// chose intensity and type as minimum in case they don't know what specific exercise List they want to do//


    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getWorkoutIntensity() {
        return workoutIntensity;
    }

    public void setWorkoutIntensity(String workoutIntensity) {
        this.workoutIntensity = workoutIntensity;
    }

    public List<String> getExerciseList() {
        return exerciseList;
    }

    public void setExerciseList(List<String> exerciseList) {
        this.exerciseList = exerciseList;
    }

    public String getRoutineType() {
        return routineType;
    }

    public void setRoutineType(String routineType) {
        this.routineType = routineType;
    }


    @Override
    public String toString() {
        return "Routine{" +
                "uniqueId='" + uniqueId + '\'' +
                ", userId=" + userId +
                ", workoutIntensity='" + workoutIntensity + '\'' +
                ", exerciseList=" + exerciseList +
                ", routineType='" + routineType + '\'' +
                '}';
    }
}

