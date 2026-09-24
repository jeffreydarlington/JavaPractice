package org.example;

public class main {

    public static Car createCar(String brand, String model, String color) {
        return new Car(brand, model, color);
    }

    public static void printCar(Car car) {
        System.out.println("Brand: " + car.brand);
        System.out.println("Model: " + car.model);
        System.out.println("Color: " + car.color);
    }

    public static void main(String[] args) {
        Car firstCar = createCar("Toyota", "Corolla", "Red");
        printCar(firstCar);
    }
}
