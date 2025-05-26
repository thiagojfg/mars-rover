package com.techstatck.algorithms.mars_rover;

import java.util.List;

public class Grid {

    public static final int MAX_WIDTH = 10;
    public static final int MAX_HEIGHT = 10;

    private final List<Coordinate> obstacles;

    public Grid(List<Coordinate> obstacles) {
        this.obstacles = obstacles;
    }

    public boolean hasObstacleAt(Coordinate coordinate) {
        return obstacles.contains(coordinate);
    }
}
