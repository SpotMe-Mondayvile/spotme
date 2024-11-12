package com.mts.spotmerest.dtos;

import com.mts.spotmerest.models.Profile;
import com.mts.spotmerest.models.User;

public class ProfileDTO {
    private String username;
    private String bio;
    private Long numberOfSpots;
    private Long status;
    private String tier;
    private String metroArea;
    private Long zip;


    public ProfileDTO(User user, Profile profile) {
        this.username = user.getUsername();
        this.bio = profile.getBio();
        this.numberOfSpots = profile.getNumberOfSpots();
        this.metroArea= profile.getMetroArea();
        this.status = profile.getStatus();
    }

    public ProfileDTO getPrivate(User user, Profile profile) {
        ProfileDTO profileDTO = new ProfileDTO(user,profile);
        profileDTO.setBio("");
        profileDTO.setZip(null);
        profileDTO.setUsername("");
        return profileDTO;
    }

    public ProfileDTO getFull(User user, Profile profile) {
        ProfileDTO profileDTO = new ProfileDTO(user,profile);
        profileDTO.
        return this
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Long getZip() {
        return zip;
    }

    public void setZip(Long zip) {
        this.zip = zip;
    }

    public Long getNumberOfSpots() {
        return numberOfSpots;
    }

    public void setNumberOfSpots(Long numberOfSpots) {
        this.numberOfSpots = numberOfSpots;
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
}
