package com.mts.spotmerest.mappers;

import com.mts.spotmerest.models.Routine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


@Repository
public interface RoutineDAO
        extends JpaRepository<Routine, Long>//gives CRUD capabilities to routine
        {     //when pulling from DB. assuming we would
                        ///for routineDAO, consider whether we need to specify by userID number


            void deleteByName(String routineName);

            Optional<Routine> findByName(String routineName);





}
