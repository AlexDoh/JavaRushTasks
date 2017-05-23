package com.javarush.task.task15.task1530;

public abstract class DrinkMaker {
    public abstract void getRightCup();
    public abstract void putIngredient();
    public abstract void pour();

    public void makeDrink() {
        this.getRightCup();
        this.putIngredient();
        this.pour();
    }
}
