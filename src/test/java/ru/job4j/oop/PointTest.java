package ru.job4j.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class PointTest {

    @Test
    void when00To20Then2() {
        Point a = new Point(0, 0);
        Point b = new Point(2, 0);
        double out = a.distance(b);
        double expected = 2.0;
        assertEquals(expected, out, 0.01);
    }

    @Test
    void when20To50Then3() {
        Point a = new Point(2, 0);
        Point b = new Point(5, 0);
        double expected = 3;
        double out = a.distance(b);
        assertEquals(expected, out, 0.01);
    }

    @Test
    void when100To20Then8() {
        Point a = new Point(10, 0);
        Point b = new Point(2, 0);
        double expected = 8;
        double out = a.distance(b);
        assertEquals(expected, out, 0.01);
    }
}