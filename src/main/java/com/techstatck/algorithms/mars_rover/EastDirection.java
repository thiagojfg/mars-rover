package com.techstatck.algorithms.mars_rover;

public class EastDirection implements RoverState {

    private final int x;
    private final int y;
    private final char direction;

    public EastDirection(int x, int y) {
        this.x = x;
        this.y = y;
        this.direction = 'E';
    }

    @Override
    public RoverState turnLeft() {
        return new NorthDirection(this.x, this.y);
    }

    @Override
    public RoverState turnRight() {
        return new SouthDirection(this.x, this.y);
    }

    @Override
    public RoverState moveForward() {
        return new EastDirection((this.x + 1) % Grid.MAX_WIDTH, this.y);
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
