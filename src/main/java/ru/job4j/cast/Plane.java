package ru.job4j.cast;

public class Plane implements Vehicle {
    @Override
    public void move() {
        System.out.println("I'm flying because there's more pressure under the wing than above.");
    }
}
