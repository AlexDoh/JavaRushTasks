package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Hippodrome {

    private List<Horse> horses = new ArrayList<>();

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public void move() {
        for(Horse horse : horses) {
            horse.move();
        }
    }

    public void print() {
        for(Horse horse : horses) {
            horse.print();
        }
        for(int i = 0; i < 10;i++) {
            System.out.println();
        }
    }

    public void run() throws InterruptedException {
        for(int i = 0; i < 100;i++) {
            this.move();
            this.print();
            Thread.sleep(200);
        }
    }

    public Horse getWinner() {
        final Comparator<Horse> comparator = (h1, h2) -> Double.compare(h1.getDistance(), h2.getDistance());

        return getHorses().stream().max(comparator).get();
    }

    public void printWinner() {
        System.out.println(String.format("Winner is %s", this.getWinner().getName()));
    }

    static Hippodrome game;

    public static void main(String[] args) throws InterruptedException {
        List<Horse> horses = new ArrayList<>();
        horses.add(new Horse("Jolo", 3, 0));
        horses.add(new Horse("Kolo", 3, 0));
        horses.add(new Horse("Yolo", 3, 0));
        game = new Hippodrome(horses);
        game.run();
        game.printWinner();
    }
}
