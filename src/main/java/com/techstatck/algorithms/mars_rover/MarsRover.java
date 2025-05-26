package com.techstatck.algorithms.mars_rover;

public class MarsRover {

    private RoverState currentState;
    private RoverState previousState;
    private final Grid grid;

    public MarsRover(Grid grid) {
        this.grid = grid;
        this.currentState = new NorthDirection(Coordinate.initial());
    }

    public void setState(RoverState newState) {
        this.previousState = this.currentState;
        if (!grid.hasObstacleAt(newState.getCoordinate())) {
            this.currentState = newState;
        }
    }

    public String execute(String commands) {
        for (char command : commands.toCharArray()) {
            if (command == 'R') {
                currentState.turnRight(this);
            }
            if (command == 'L') {
                currentState.turnLeft(this);
            }
            if (command == 'M') {
                currentState.moveForward(this);
                // If the current state and previous state are the same, an obstacle was found
                if (previousState == currentState) {
                    return "O:" + previousState.getPosition();
                }
            }
        }
        return this.currentState.getPosition();
    }
}
