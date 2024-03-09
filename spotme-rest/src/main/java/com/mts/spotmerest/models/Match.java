package com.mts.spotmerest.models;

import jakarta.persistence.*;

@Entity
@Table(name="matches")
public class Match {
    @Id
    @SequenceGenerator(
            name="match_sequence",
            sequenceName="match_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "match_sequence"
    )
    private Long id;
    private Long authorId;
    private Long responderId;
    private String gymId;
    private String name;
    private Integer age;
    private String gender;
    private String race;
    private String status;

    public Match(Long id, Long userId, String gymId, String name, Integer age, String gender, String race, String status) {
        this.id = id;
        this.authorId = userId;
        this.gymId = gymId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.race = race;
        this.status = status;
    }

    public Match() {
    }

    public Match(Long id, Long userId, String gymId) {
        this.id = id;
        this.authorId = userId;
        this.gymId = gymId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGymId() {
        return gymId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getResponderId() {
        return responderId;
    }

    public void setResponderId(Long responderId) {
        this.responderId = responderId;
    }

    public void setGymId(String gymId) {
        this.gymId = gymId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", authorId=" + authorId +
                ", responderId=" + responderId +
                ", gymId='" + gymId + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", race='" + race + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
