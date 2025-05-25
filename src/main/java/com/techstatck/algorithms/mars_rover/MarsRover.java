package com.techstatck.algorithms.mars_rover;

public class MarsRover {

    private RoverState currentState;
    private final Grid grid;

    public MarsRover(Grid grid) {
        this.grid = grid;
        this.currentState = new NorthDirection(0, 0);
    }

    public String execute(String commands) {
        for (char command : commands.toCharArray()) {
            RoverState newState = null;
            if (command == 'R') {
                newState = currentState.turnRight();
            }
            if (command == 'L') {
                newState = currentState.turnLeft();
            }
            if (command == 'M') {
                newState = currentState.moveForward();
                if (grid.hasObstacleAt(newState.getPositionAtX(), newState.getPositionAtY())) {
                    return "O:" + currentState.getPosition();
                }
            }
            this.currentState = newState;
        }
        return this.currentState.getPosition();
    }
}
