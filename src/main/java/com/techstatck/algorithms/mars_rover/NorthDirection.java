package com.techstatck.algorithms.mars_rover;

public class NorthDirection implements RoverState {

    private final int x;
    private final int y;
    private final char direction;

    public NorthDirection(int x, int y) {
        this.x = x;
        this.y = y;
        this.direction = 'N';
    }

    @Override
    public RoverState turnLeft() {
        return new WestDirection(x, y);
    }

    @Override
    public RoverState turnRight() {
        return new EastDirection(x, y);
    }

    @Override
    public RoverState moveForward() {
        return new NorthDirection(x, (y + 1) % Grid.MAX_HEIGHT);
    }

    @Override
    public int getPositionAtX() {
        return this.x;
    }

    @Override
    public int getPositionAtY() {
        return this.y;
    }

    @Override
    public char getDirection() {
        return this.direction;
    }
}
