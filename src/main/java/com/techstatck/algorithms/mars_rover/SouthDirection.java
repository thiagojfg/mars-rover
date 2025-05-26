package com.techstatck.algorithms.mars_rover;

public class SouthDirection implements RoverState {

    private final Coordinate coordinate;
    private final Direction direction = Direction.SOUTH;

    public SouthDirection(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public void turnLeft(MarsRover rover) {
        rover.setState(new EastDirection(this.coordinate));
    }

    @Override
    public void turnRight(MarsRover rover) {
        rover.setState(new WestDirection(this.coordinate));
    }

    @Override
    public void moveForward(MarsRover rover) {
        rover.setState(new SouthDirection(this.coordinate.nextCoordinate(this.direction)));
    }

    @Override
    public Coordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public char getDirectionValue() {
        return this.direction.getValue();
    }
}
