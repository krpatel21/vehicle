package com.example.vehicle.vehicle;

import com.example.vehicle.core.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Vehicle extends BaseEntity {
    @Column
    @NotNull
    @Size(min = 1, max = 40)
    private String make;
    @Column
    @NotNull
    @Size(min = 1, max = 40)
    private String model;
    @Column
    @NotNull
    private int year;

    public Vehicle() {
    }

    public Vehicle(@NotNull @Size(min = 1, max = 40) String make, @NotNull @Size(min = 1, max = 40) String model, @NotNull int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
