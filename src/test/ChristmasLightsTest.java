package test;

import main.ChristmasLights;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static java.lang.Math.random;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ChristmasLightsTest {

    private ChristmasLights christmasLightsGrid;

    @BeforeEach
    void setup() {
        christmasLightsGrid = new ChristmasLights();
    }

    private void turnOnLightsAndCheckIfSuccessfull(int rowStart, int colStart, int rowEnd, int colEnd) {
        christmasLightsGrid.turnLightOnForRange(rowStart,colStart, rowEnd,colEnd);
        assertEquals(christmasLightsGrid.areTurnedOnForRange(rowStart,colStart, rowEnd,colEnd), 1);
    }

    private void turnOffLightsAndCheckIfSuccessfull(int rowStart, int colStart, int rowEnd, int colEnd) {
        christmasLightsGrid.turnLightOffForRange(rowStart,colStart, rowEnd,colEnd);
        assertEquals(christmasLightsGrid.areTurnedOffForRange(rowStart,colStart, rowEnd,colEnd), 0);
    }

    private void toggleLightsAndCheckIfSuccessfull(int rowStart, int colStart, int rowEnd, int colEnd, int lightValue) {
        christmasLightsGrid.toggleLightForRange(rowStart,colStart, rowEnd,colEnd);
        switch (lightValue) {
            case 0:
                assertEquals(christmasLightsGrid.areTurnedOffForRange(rowStart,colStart, rowEnd,colEnd), 0);
                break;
            case 1:
                assertEquals(christmasLightsGrid.areTurnedOnForRange(rowStart,colStart, rowEnd,colEnd), 1);
                break;
        }
    }

    @Test
    void should_create_the_grid() {
        new ChristmasLights();
    }

    @Test
    void should_have_ligths_off_0_when_grid_created() {
        Random random = new Random();
        assertEquals(christmasLightsGrid.getValueAtPosition(
                (int) ((Math.random() * (999 - 0)) + 0),
                (int) ((Math.random() * (999 - 0)) + 0)
                ),
                0);
    }

    @Test
    void should_turn_light_on_for_one_coordinate() {
        christmasLightsGrid.turnLightOnAt(4,4);
        assertEquals(christmasLightsGrid.isTurnedOn(4,4), 1);
    }

    @Test
    void should_turn_light_off_for_one_coordinate() {
        christmasLightsGrid.turnLightOnAt(7,4);
        assertEquals(christmasLightsGrid.isTurnedOn(7,4), 1);
        christmasLightsGrid.turnLightOffAt(7,4);
        assertEquals(christmasLightsGrid.isTurnedOff(7,4), 0);
    }

    @Test
    void should_toggle_light_for_one_coordinate() {
        christmasLightsGrid.turnLightOnAt(10,63);
        assertEquals(christmasLightsGrid.isTurnedOn(10,63), 1);
        christmasLightsGrid.toggleLightAt(10,63);
        assertEquals(christmasLightsGrid.getValueAtPosition(10,63), 3);
    }

    @Test
    void should_turn_light_on_for_a_range() {
        turnOnLightsAndCheckIfSuccessfull(
                4,4,
                4,8);
    }

    @Test
    void should_turn_light_off_for_a_range() {
        turnOffLightsAndCheckIfSuccessfull(
                4,4,
                4,8);
    }

    @Test
    void should_toggle_light_for_a_range() {
        christmasLightsGrid.turnLightOnForRange(
                2,2,
                2,10);
        assertEquals(christmasLightsGrid.areTurnedOnForRange(
                2,2,
                2,10),
                1);
        christmasLightsGrid.toggleLightForRange(2,2,
                2,10);
        assertEquals(christmasLightsGrid.areTurnedOnForRange(
                2,2,
                2,10),
                3);
    }

    @Test
    void should_validate_santa_instructions() {
        // turn on 887,9 through 959,629
        turnOnLightsAndCheckIfSuccessfull(
                887,9,
                959,629);

        // turn on 454,398 through 844,448
        turnOnLightsAndCheckIfSuccessfull(
                454,398,
                844,448);

        // turn off 539,243 through 559,965
        turnOffLightsAndCheckIfSuccessfull(
                539,243,
                559,965);

        // turn off 370,819 through 676,868
        turnOffLightsAndCheckIfSuccessfull(
                370,819,
                676,868);

        // turn off 145,40 through 370,997
        turnOffLightsAndCheckIfSuccessfull(
                145,40,
                370,997);

        // turn off 301,3 through 808,453
        turnOffLightsAndCheckIfSuccessfull(
                301,3,
                808,453);

        // turn on 351,678 through 951,908
        turnOnLightsAndCheckIfSuccessfull(
                351,678,
                951,908);

        // toggle 720,196 through 897,994
        toggleLightsAndCheckIfSuccessfull(
                720,196,
                897,994,
                2);

        // toggle 831,394 through 904,860
        toggleLightsAndCheckIfSuccessfull(
                831,394,
                904,860,
                3);

        assertEquals(christmasLightsGrid.totalNumberOfLights(), 145501);
    }

}