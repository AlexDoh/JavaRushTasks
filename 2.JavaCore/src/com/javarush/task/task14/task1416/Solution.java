package com.javarush.task.task14.task1416;

/* 
Исправление ошибок
*/

public class Solution {
    public static void main(String[] args) {
        Swimmable animal = new Orca();
        animal.swim();
        animal = new Whale();
        animal.swim();
        animal = new Otter();
        animal.swim();
        Walkable animal2 = new Otter();
        animal2.walk();
    }

    public static void test(Swimmable animal) {
        animal.swim();
    }

    static interface Walkable {
        void walk();
    }

    static interface Swimmable {
        void swim();
    }

    static abstract class OceanAnimal {
        public void swim() {
            OceanAnimal currentAnimal = (OceanAnimal) getCurrentAnimal();
            currentAnimal.swimming();
        }

        private void swimming() {
            System.out.println(getCurrentAnimal().getClass().getSimpleName() + " is swimming");
        }

        abstract Swimmable getCurrentAnimal();
    }

    static class Orca extends OceanAnimal implements Swimmable {
        public Swimmable getCurrentAnimal(){
            return new Orca();
        }
    }

    static class Whale extends OceanAnimal implements Swimmable {
        public Swimmable getCurrentAnimal(){
            return new Orca();
        }
    }

    static class Otter implements Walkable,Swimmable {
        public void swim() {
            Otter currentAnimal = getCurrentAnimal();
            currentAnimal.swimming();
        }

        private void swimming() {
            System.out.println(getCurrentAnimal().getClass().getSimpleName() + " is swimming");
        }

        public Otter getCurrentAnimal(){
            return new Otter();
        }

        public void walk(){
            System.out.println(getCurrentAnimal().getClass().getSimpleName() + " is walking");
        }
    }
}
