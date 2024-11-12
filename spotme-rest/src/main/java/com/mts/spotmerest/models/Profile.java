package com.mts.spotmerest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="profiles")
public class Profile {
    @Id
    @SequenceGenerator(
            name="profile_sequence",
            sequenceName="profile_sequence",
            allocationSize = 1
//            ,initialValue = 1000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "profile_sequence"
    )
    private Long id;
    private Long userId;
    private double rating;
    private Long numberOfSpots;
    private String bio;
    private Long status;
    private String tier;
    private String metroArea;
    private Long zip;

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Long getNumberOfSpots() {
        return numberOfSpots;
    }

    public void setNumberOfSpots(Long numberOfSpots) {
        this.numberOfSpots = numberOfSpots;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public String getMetroArea() {
        return metroArea;
    }

    public void setMetroArea(String metroArea) {
        this.metroArea = metroArea;
    }

    public Long getZip() {
        return zip;
    }

    public void setZip(Long zip) {
        this.zip = zip;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Profile updateAttributes(Profile s){
        Profile newProfile = new Profile();
        newProfile.setBio(s.getBio());
        newProfile.setMetroArea(s.getMetroArea());
        newProfile.setZip(s.getZip());
        newProfile.setNumberOfSpots(s.getNumberOfSpots());
        newProfile.setStatus(s.getStatus());
        return newProfile;
    }

    public Date getCurrentTime(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        return date;
    }

    @Override
    public String toString() {
        return "ProfileDTO{" +
                "id=" + id +
                ", rating=" + rating +
                ", numberOfSpots=" + numberOfSpots +
                ", bio='" + bio + '\'' +
                ", status=" + status +
                ", tier='" + tier + '\'' +
                ", metroArea='" + metroArea + '\'' +
                ", zip=" + zip +
                '}';
    }
}
