package com.techstatck.algorithms.mars_rover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class MarsRoverTest {

    private MarsRover rover;

    @BeforeEach
    public void setUp() {
        rover = new MarsRover(new Grid(Collections.emptyList()));
    }

    @Test
    public void should_be_in_initial_position() {
        assertThat(rover.execute(""), is("0:0:N"));
    }

    @ParameterizedTest
    @CsvSource(value = {"M, 0:1:N", "MM, 0:2:N"})
    public void should_move_to_north(String commands, String expected_position) {
        assertThat(rover.execute(commands), is(expected_position));
    }

    @ParameterizedTest
    @CsvSource(value = {"L,0:0:W", "LL,0:0:S", "LLL,0:0:E", "LLLL,0:0:N"})
    public void should_turn_left(String commands, String expected_position) {
        assertThat(rover.execute(commands), is(expected_position));
    }

    @ParameterizedTest
    @CsvSource(value = {"R,0:0:E", "RR,0:0:S", "RRR,0:0:W", "RRRR,0:0:N", "RM,1:0:E", "RMM,2:0:E"})
    public void should_turn_right_and_move(String commands, String expected) {
        assertThat(rover.execute(commands), is(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"MRML, 1:1:N", "MRMRM, 1:0:S", "RMMM, 3:0:E", "RMMMRRMMM, 0:0:W"})
    public void should_forward_and_back(String commands, String expected) {
        assertThat(rover.execute(commands), is(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "MMMMMMMMMM, 0:0:N",
            "MMMMMMMMMMM, 0:1:N"
    })
    public void should_wrap_from_top_to_bottom_when_moving_north(String commands, String expected) {
        assertThat(rover.execute(commands), is(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "RRM, 0:9:S"
    })
    public void should_wrap_from_bottom_to_top_when_moving_south(String commands, String expected) {
        assertThat(rover.execute(commands), is(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "RMMMMMMMMMM, 0:0:E",
            "RMMMMMMMMMMM, 1:0:E"
    })
    public void should_wrap_from_right_to_left_when_moving_to_east(String commands, String expected) {
        assertThat(rover.execute(commands), is(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "LM, 9:0:W",
    })
    public void should_wrap_from_left_to_right_when_moving_west(String commands, String expected) {
        assertThat(rover.execute(commands), is(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "MMMMMMMMMM, 0, 5, O:0:4:N",
            "RMMMMMMM, 5, 0, O:4:0:E",
            "RMMMMMLMMMMMM, 5, 5, O:5:4:N",
            "RMMMMMMMMLMRMRM, 9, 0, O:9:1:S",
            "MMMMMMRMMMMMMRMRM, 5, 5, O:6:5:W"
    })
    public void should_handle_obstacles(String commands, int obstacle_x, int obstacle_y, String expected) {
        List<Grid.Obstacle> obstacles = List.of(new Grid.Obstacle(obstacle_x, obstacle_y));
        MarsRover rover = new MarsRover(new Grid(obstacles));
        assertThat(rover.execute(commands), is(expected));
    }
}
