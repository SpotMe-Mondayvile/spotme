package com.mts.spotmerest.models.friendships;


import jakarta.persistence.*;

@Entity
@Table(name = "friends")
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long friendId;
    private Long user;
    private Boolean isActive;

    public Friend(Long friendId, Long user, Boolean isActive) {
        this.id = id;
        this.friendId = friendId;
        this.user = user;
        this.isActive = isActive;
    }

    public Friend() {
    }

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