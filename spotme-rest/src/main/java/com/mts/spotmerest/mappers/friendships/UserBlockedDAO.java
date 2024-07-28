package com.mts.spotmerest.mappers.friendships;

import com.mts.spotmerest.models.friendships.BlockUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.Set;

public interface UserBlockedDAO extends JpaRepository<BlockUser, Long> {

    @Query(value = "SELECT b FROM BlockUser b WHERE b.user = :user")
    Set<Optional<BlockUser>> findAllBlockUsers(Long user);

    @Query(value = "SELECT b FROM BlockUser b WHERE b.targetUserId = :targetUserId")
    Set<Optional<BlockUser>> findAllBlockUsersByTargetUserId(Long targetUserId);
}
