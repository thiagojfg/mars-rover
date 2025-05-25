package com.techstatck.algorithms.mars_rover;

import java.util.List;

public class Grid {

    public static final int MAX_WIDTH = 10;
    public static final int MAX_HEIGHT = 10;

    private final List<Obstacle> obstacles;

    public Grid(List<Obstacle> obstacles) {
        this.obstacles = obstacles;
    }

    public boolean hasObstacleAt(int x, int y) {
        return obstacles.stream().anyMatch(obstacle -> obstacle.x == x && obstacle.y == y);
    }

    public record Obstacle(int x, int y){}
}
