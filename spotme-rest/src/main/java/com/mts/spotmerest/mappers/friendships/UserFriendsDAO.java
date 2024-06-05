package com.mts.spotmerest.mappers.friendships;

import com.mts.spotmerest.models.friendships.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserFriendsDAO extends JpaRepository<Friend,Long> {

    @Query(value = "SELECT s FROM Friend s WHERE s.user = :userId or s.friendId= :userId")
    Set<Optional<Friend>> findAllFriends(Long userId);

    @Query(value = "SELECT s FROM Friend s WHERE (s.user = :userId and s.friendId= :friendId) or (s.user = :friendId and s.friendId= :userId)")
    Optional<Friend> findFriendByUserAndFriendId(Long friendId, Long userId);
}
