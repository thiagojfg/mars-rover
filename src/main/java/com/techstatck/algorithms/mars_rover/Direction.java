package com.techstatck.algorithms.mars_rover;

public enum Direction {
    NORTH('N'),
    EAST('E'),
    SOUTH('S'),
    WEST('W');

    private final char value;

    Direction(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }
}
