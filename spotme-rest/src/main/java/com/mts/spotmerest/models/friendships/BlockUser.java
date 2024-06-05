package com.mts.spotmerest.models.friendships;

import com.mts.spotmerest.models.User;
import jakarta.persistence.*;

@Entity
@Table(name = "block_users")
public class BlockUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long targetUserId;
    private Long user;

    public BlockUser(Long targetUserId, Long user) {
        this.targetUserId = targetUserId;
        this.user = user;
    }

    public Long getTargetUserId() {
        return targetUserId;
    }

    public void setTargetUserId(Long targetUserId) {
        this.targetUserId = targetUserId;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

}