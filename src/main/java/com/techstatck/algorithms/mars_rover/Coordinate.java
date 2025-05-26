package com.techstatck.algorithms.mars_rover;

public record Coordinate(int x, int y) {

    public static Coordinate initial() {
        return new Coordinate(0, 0);
    }

    public Coordinate nextCoordinate(Direction direction) {
        int x = this.x();
        int y = this.y();
        return switch (direction) {
            case NORTH -> new Coordinate(x, (y + 1) % Grid.MAX_HEIGHT);
            case SOUTH -> new Coordinate(x, y > 0 ? y - 1 : Grid.MAX_HEIGHT - 1);
            case EAST -> new Coordinate((x + 1) % Grid.MAX_WIDTH, y);
            case WEST -> new Coordinate(x > 0 ? x - 1 : Grid.MAX_WIDTH - 1, y);
        };
    }
}
