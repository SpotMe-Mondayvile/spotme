package com.mts.spotmerest.mappers;

import com.mts.spotmerest.models.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface MatchDAO extends JpaRepository<Match, Long> {
    Optional<Match> findMatchById(Long id);
}
