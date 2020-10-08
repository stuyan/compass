package ru.stuyan.compass.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangeTest {

    @Test
    void in() {
        Range range = new Range(316d, 45d);
        assertTrue(range.in(360d));
        assertTrue(range.in(345d));
        assertTrue(range.in(316d));
        assertTrue(range.in(45d));
        assertTrue(range.in(15d));
        assertTrue(range.in(0d));
        assertFalse(range.in(150d));
    }
}