package com.mts.spotmerest.mappers.friendships;

import com.mts.spotmerest.models.friendships.UserFriends;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserFriendsDAO extends JpaRepository<UserFriends,Long> {

}
