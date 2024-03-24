package com.example.dinemaster.model;

import javax.persistence.*;
import com.example.dinemaster.model.Restaurant;

@Entity
@Table(name = "chef")
public class Chef {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "expertise")
    private String expertise;

    @Column(name = "experienceyears")
    private int experienceYears;

    @ManyToOne
    @JoinColumn(name = "restaurantid")
    private Restaurant restaurant;

    public Chef(String firstName, String lastName, String expertise, int experienceYears, Restaurant restaurant) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.expertise = expertise;
        this.experienceYears = experienceYears;
        this.restaurant = restaurant;
    }

    public Chef() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public String getExpertise() {
        return this.expertise;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public int getExperienceYears() {
        return this.experienceYears;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Restaurant getRestaurant() {
        return this.restaurant;
    }

}