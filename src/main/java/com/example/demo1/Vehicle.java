package com.example.demo1;

public class Vehicle {
    private String make;
    private String model;
    private String year;
    private String plateNumber;
    private String fuelType;
    private String color;
    private String ownerName;

    public Vehicle(String make, String model, String year, String plateNumber, String fuelType, String color, String ownerName) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.plateNumber = plateNumber;
        this.fuelType = fuelType;
        this.color = color;
        this.ownerName = ownerName;
    }

    public String getMake() { return make; }
    public String getModel() { return model; }
    public String getYear() { return year; }
    public String getPlateNumber() { return plateNumber; }
    public String getFuelType() { return fuelType; }
    public String getColor() { return color; }
    public String getOwnerName() { return ownerName; }
}