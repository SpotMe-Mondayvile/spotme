package com.mts.spotmerest.mappers.friendships;

import com.mts.spotmerest.models.friendships.BlockUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.Set;

public interface UserBlockedDAO extends JpaRepository<BlockUser, Long> {


    Set<Optional<BlockUser>> findAllById(Long userId);

    Set<Optional<BlockUser>> findAllByTargetUserId(Long targetUserId);
}
