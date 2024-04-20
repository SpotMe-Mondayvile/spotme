package com.mts.spotmerest.models.friendships;

import com.mts.spotmerest.models.User;
import jakarta.persistence.*;

@Entity
@Table(name = "block_users")
public class BlockUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int targetUserId;


    private User user;

    public int getTargetUserId() {
        return targetUserId;
    }

    public void setTargetUserId(int targetUserId) {
        this.targetUserId = targetUserId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}