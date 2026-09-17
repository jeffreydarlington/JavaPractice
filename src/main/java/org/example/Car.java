package org.example;

public class Car {
    public String brand = null;
    public String model = null;
    public String color = null;

    public Car(){
    }

    public Car(String brand, String model, String color){
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    public void setColor(String newColor){
        this.color = newColor;
    }
}

