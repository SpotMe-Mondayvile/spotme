package com.mts.spotmerest.models.friendships;


import com.mts.spotmerest.models.User;
import jakarta.persistence.*;

@Entity
@Table(name = "_friends")
public class UserFriends {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long friendId;

    private Long user;

    public Long getFriendId() {
        return friendId;
    }

    public void setFriendId(Long friendId) {
        this.friendId = friendId;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

}