package com.mts.spotmerest.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

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
    private String email;
    private String phoneNumber;
    private String name;
    private Integer age;
    private LocalDate dob;
    private String gender;
    private String race;

    public User(){

    }
    public User(String username,
                Integer age,
                String gender,
                String race) {
        this.username = username;
        this.age = age;
        this.dob= null;
        this.gender = gender;
        this.race = race;
        this.email = null;
        this.phoneNumber = null;
        this.name = null;
    }


    public User(Long id, String username, String email, String phoneNumber, String name, LocalDate dob, String gender, String race) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.race = race;
        getCalculatedAge();
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
    @Transient
    public void getCalculatedAge() {
        if(this.dob!= null){
            this.age=Period.between(this.dob,LocalDate.now()).getYears();
        }
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dob=" + dob +
                ", gender='" + gender + '\'' +
                ", race='" + race + '\'' +
                '}';
    }
}
