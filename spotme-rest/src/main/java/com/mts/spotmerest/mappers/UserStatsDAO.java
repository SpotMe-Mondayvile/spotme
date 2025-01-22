package com.mts.spotmerest.mappers;

import com.mts.spotmerest.models.Spot;
import com.mts.spotmerest.models.UserStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserStatsDAO extends JpaRepository<UserStats, Long> {

    Optional<UserStats> findUserStatsById(Long id);
    List<Optional<UserStats>> finduserStatsByUserId(Long userId);
//    Optional<Spot> findSpotByUserId(Long userId);
}
