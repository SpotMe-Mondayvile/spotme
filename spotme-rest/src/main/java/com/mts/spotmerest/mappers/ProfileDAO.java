package com.mts.spotmerest.mappers;

import com.mts.spotmerest.models.Profile;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileDAO
        extends JpaRepository<Profile,Long> {

    @Query(value = "SELECT s FROM ProfileDTO s WHERE s.username = :name")
    Optional<Profile> findProfileByProfileName(@Param("name") String username);

    @Query(value = "SELECT s FROM ProfileDTO s WHERE s.email = :email")
    Optional<Profile> findProfileByProfileEmail(@Param("email") String email);

    Optional<Profile> findByEmail(String email);

    @NonNull
    Optional<Profile> findById(Long id);
}
