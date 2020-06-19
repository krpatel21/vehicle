package com.example.vehicle.vehicle;

import com.example.vehicle.core.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

    @Column
    @NotNull
    @Enumerated(EnumType.STRING)
    private Type type;

    public Vehicle() {
    }

    public Vehicle(@NotNull @Size(min = 1, max = 40) String make, @NotNull @Size(min = 1, max = 40) String model, @NotNull int year, @NotNull Type type) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.type = type;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
