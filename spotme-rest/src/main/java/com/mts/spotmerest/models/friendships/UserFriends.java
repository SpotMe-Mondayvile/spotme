package com.mts.spotmerest.models.friendships;


import com.mts.spotmerest.models.User;
import jakarta.persistence.*;

@Entity
@Table(name = "user_friends")
public class UserFriends {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long friendId;

    private User user;

    public Long getFriendId() {
        return friendId;
    }

    public void setFriendId(Long friendId) {
        this.friendId = friendId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}