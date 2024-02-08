package com.mts.spotmerest.models;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @SequenceGenerator(
            name="user_sequence",
            sequenceName="user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    private String username;
    private Integer age;
    private String gender;
    private String race;

    public User(Long id, String username, Integer age, String gender, String race) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.gender = gender;
        this.race = race;
    }
    public User(){

    }
    public User(String username,
                Integer age,
                String gender,
                String race) {
        this.username = username;
        this.age = age;
        this.gender = gender;
        this.race = race;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", race='" + race + '\'' +
                '}';
    }
}
