package com.mts.spotmerest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name="USER_STATS")
public class UserStats {
    @Id
    @SequenceGenerator(
            name="user_stat_sequence",
            sequenceName="user_stat_sequence",
            allocationSize = 1
//            ,initialValue = 1000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_stat_sequence"
    )
    private Long id;
    private Long userId;
    private BigDecimal rating;
    private Long spotsCompleted;
    private String description;
    private Date createdAt;
    private String status; //open or closed
    private Boolean isPrivate;
    private Boolean enabled;

    public UserStats(Long id, Long userId, Date createdAt) {
        this.id = id;
        this.userId = userId;
        this.createdAt = createdAt;
    }



    public UserStats(Long id, Long userId, BigDecimal rating, Long spotsCompleted, String description, Date createdAt, String status, Boolean isPrivate) {
        this.id = id;
        this.userId = userId;
        this.rating = rating;
        this.spotsCompleted = spotsCompleted;
        this.description = description;
        this.createdAt = createdAt;
        this.status = status;
        this.isPrivate = isPrivate;
        this.enabled = true;
    }

    public Long getId() {
        return id;
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public Long getSpotsCompleted() {
        return spotsCompleted;
    }

    public void setSpotsCompleted(Long spotsCompleted) {
        this.spotsCompleted = spotsCompleted;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getPrivate() {
        return isPrivate;
    }

    public void setPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "UserStats{" +
                "id=" + id +
                ", userId=" + userId +
                ", rating=" + rating +
                ", spotsCompleted=" + spotsCompleted +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", status='" + status + '\'' +
                ", isPrivate=" + isPrivate +
                ", enabled=" + enabled +
                '}';
    }

    public UserStats cloneStatsObject(){
        UserStats userStats = new UserStats(
                this.getId(),
                this.getUserId(),
                this.getRating(),
                this.getSpotsCompleted(),
                this.getDescription(),
                this.getCreatedAt(),
                this.getStatus(),
                this.getPrivate()
        );
        return userStats;
    }

    public Date getCurrentTime(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        return date;
    }
}
