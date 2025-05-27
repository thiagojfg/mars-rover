# Mars Rover Simulation

A Java implementation of the classic Mars Rover problem, simulating a rover navigating on a grid-based Martian surface.

## Objective

This project simulates a rover on Mars that can be controlled with simple commands to navigate a 10x10 grid. The rover can:
- Move forward in its current direction
- Turn left or right
- Detect and avoid obstacles
- Wrap around the edges of the grid (when reaching one edge, it continues from the opposite edge)

## Implementation Approach

The project uses several design patterns and principles:

1. **State Pattern**: Each direction (North, South, East, West) is implemented as a separate state class that implements the `RoverState` interface. This allows the rover's behavior to change based on its current direction.

2. **Immutable Objects**: The `Coordinate` class is implemented as a Java record, ensuring coordinates are immutable.

3. **Command Pattern**: The rover processes a string of commands ('M' for move, 'L' for turn left, 'R' for turn right) to execute a sequence of actions.

4. **Obstacle Detection**: The rover checks for obstacles before moving and stops before hitting them, reporting the obstacle's position.

5. **Grid Wrapping**: When the rover reaches the edge of the grid, it wraps around to the opposite side, simulating a cylindrical or toroidal surface.

## Potential Improvements

1. **Command Extensibility**: Add more commands beyond the basic move and turn operations.

2. **Variable Grid Size**: Make the grid dimensions configurable rather than fixed constants.

3. **Multiple Rovers**: Support multiple rovers on the same grid that can detect each other as obstacles.

4. **Terrain Types**: Add different terrain types that affect movement (e.g., slower movement on sand).

5. **Path Planning**: Implement algorithms for the rover to find optimal paths around obstacles.

6. **User Interface**: Create a graphical interface to visualize the rover's movement on the grid.

7. **Persistence**: Add the ability to save and load the state of the simulation.