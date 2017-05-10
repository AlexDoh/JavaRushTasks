package com.javarush.task.task14.task1404;

public class Cat {

    private String name;

    protected Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "Я уличный кот " + getName();
    }
}
