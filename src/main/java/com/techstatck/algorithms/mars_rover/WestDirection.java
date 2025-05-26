package com.techstatck.algorithms.mars_rover;

public class WestDirection implements RoverState {

    private final Coordinate coordinate;
    private final Direction direction = Direction.WEST;

    public WestDirection(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public void turnLeft(MarsRover rover) {
        rover.setState(new SouthDirection(this.coordinate));
    }

    @Override
    public void turnRight(MarsRover rover) {
        rover.setState(new NorthDirection(this.coordinate));
    }

    @Override
    public void moveForward(MarsRover rover) {
        Coordinate nextCoordinate = this.coordinate.nextCoordinate(this.direction);
        rover.setState(new WestDirection(nextCoordinate));
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
