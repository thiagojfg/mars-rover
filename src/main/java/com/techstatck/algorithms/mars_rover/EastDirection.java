package com.techstatck.algorithms.mars_rover;

public class EastDirection implements RoverState {

    private final Coordinate coordinate;
    private final Direction direction = Direction.EAST;

    public EastDirection(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public void turnLeft(MarsRover rover) {
        rover.setState(new NorthDirection(this.coordinate));
    }

    @Override
    public void turnRight(MarsRover rover) {
        rover.setState(new SouthDirection(this.coordinate));
    }

    @Override
    public void moveForward(MarsRover rover) {
        rover.setState(new EastDirection(this.coordinate.nextCoordinate(this.direction)));
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
