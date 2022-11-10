package com.example.carrentalsystem.models;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String model;

    @Column(nullable = false)
    private boolean isAvailable;

    @Column(nullable = false)
    private double monthlyRent;

    public Car(String model, boolean isAvailable, double monthlyRent) {
        this.model = model;
        this.isAvailable = isAvailable;
        this.monthlyRent = monthlyRent;
    }

    public Car() {

    }

    public String getModel() {
        return model;
    }

    public Car setModel(String model) {
        this.model = model;
        return this;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Car setAvailable(boolean available) {
        isAvailable = available;
        return this;
    }

    public double getMonthlyRent() {
        return monthlyRent;
    }

    public Car setMonthlyRent(double monthlyRent) {
        this.monthlyRent = monthlyRent;
        return this;
    }

    public Long getId() {
        return id;
    }

    public Car setId(Long id) {
        this.id = id;
        return this;
    }
}

