package com.mts.spotmerest.mappers;

import com.mts.spotmerest.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDOA
        extends JpaRepository<User,Long> {

}
