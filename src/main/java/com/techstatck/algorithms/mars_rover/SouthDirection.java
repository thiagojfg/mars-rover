package com.techstatck.algorithms.mars_rover;

public class SouthDirection implements RoverState {

    private final int x;
    private final int y;
    private final char direction;

    public SouthDirection(int x, int y) {
        this.x = x;
        this.y = y;
        this.direction = 'S';
    }

    @Override
    public RoverState turnLeft() {
        return new EastDirection(this.x, this.y);
    }

    @Override
    public RoverState turnRight() {
        return new WestDirection(this.x, this.y);
    }

    @Override
    public RoverState moveForward() {
        return new SouthDirection(this.x, this.y > 0 ? this.y - 1 : Grid.MAX_HEIGHT - 1);
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
