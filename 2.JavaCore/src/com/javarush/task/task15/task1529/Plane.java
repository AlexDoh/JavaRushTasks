package com.javarush.task.task15.task1529;

public class Plane implements Flyable {
    private int passangers;

    public Plane(int passengers) {
        this.passangers = passengers;
    }

    @Override
    public void fly() {
        System.out.println("I am Plane and can fly.");
    }
}
