package com.mts.spotmerest.models.friendships;

import jakarta.persistence.*;

@Entity
@Table(name = "block_users")
public class BlockUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Long targetUserId;

    public BlockUser(Long targetUserId, Long id) {
        this.targetUserId = targetUserId;
        this.id = id;
    }

    public BlockUser() {
    }

    public Long getTargetUserId() {
        return targetUserId;
    }

    public void setTargetUserId(Long targetUserId) {
        this.targetUserId = targetUserId;
    }

    public Long getUserId() {
        return id;
    }

    public void setUserId(Long userId) {
        this.id = userId;
    }

}