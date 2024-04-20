package com.mts.spotmerest.mappers.friendships;

import com.mts.spotmerest.models.friendships.FriendRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRequestDAO extends JpaRepository<FriendRequest,Long> {
}
