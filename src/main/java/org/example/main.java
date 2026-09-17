package org.example;

public class main {
    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();

        car1.setColor("red");
        System.out.println(car1.color);
        car2.setColor("blue");
        System.out.println(car2.color);
        car3.setColor("green");
        System.out.println(car3.color);
    }
}
