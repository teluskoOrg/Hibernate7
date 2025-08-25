package com.telusko;

import jakarta.persistence.Embeddable;

@Embeddable
public class Laptop {
    private String brand;
    private String model;
    private int ram;


    public void setModel(String model) {
        this.model = model;
    }


    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public int getRam() {
        return ram;
    }

    public String getModel() {
        return model;
    }


    @Override
    public String toString() {
        return "Laptop{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", ram=" + ram +
                '}';
    }
}
