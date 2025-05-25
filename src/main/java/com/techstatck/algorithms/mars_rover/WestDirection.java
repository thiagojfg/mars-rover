package com.techstatck.algorithms.mars_rover;

public class WestDirection implements RoverState {

    private final int x;
    private final int y;
    private final char direction;

    public WestDirection(int x, int y) {
        this.x = x;
        this.y = y;
        this.direction = 'W';
    }

    @Override
    public RoverState turnLeft() {
        return new SouthDirection(this.x, this.y);
    }

    @Override
    public RoverState turnRight() {
        return new NorthDirection(this.x, this.y);
    }

    @Override
    public RoverState moveForward() {
        return new WestDirection(this.x > 0 ? this.x - 1 : Grid.MAX_WIDTH - 1, this.y);
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
