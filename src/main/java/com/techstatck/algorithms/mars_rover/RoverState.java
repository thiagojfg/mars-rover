package com.techstatck.algorithms.mars_rover;

public interface RoverState {
    RoverState turnLeft();
    RoverState turnRight();
    RoverState moveForward();
    int getPositionAtX();
    int getPositionAtY();
    char getDirection();
    default String getPosition() {
        return getPositionAtX() + ":" + getPositionAtY()+ ":" + getDirection();
    }
}
