package com.mts.spotmerest.mappers.friendships;

import com.mts.spotmerest.models.friendships.UserFriends;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserFriendsDAO extends JpaRepository<UserFriends,Long> {

    @Query(value = "SELECT s FROM UserFriends s WHERE s.user = :userId or s.friendId= :userId")
    List<Optional<UserFriends>> findAllFriends(Long userId);
}
