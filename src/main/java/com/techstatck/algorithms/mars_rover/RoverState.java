package com.techstatck.algorithms.mars_rover;

public interface RoverState {
    void turnLeft(MarsRover rover);
    void turnRight(MarsRover rover);
    void moveForward(MarsRover rover);
    Coordinate getCoordinate();
    char getDirectionValue();
    default String getPosition() {
        return getCoordinate().x() + ":" + getCoordinate().y()+ ":" + getDirectionValue();
    }
}
