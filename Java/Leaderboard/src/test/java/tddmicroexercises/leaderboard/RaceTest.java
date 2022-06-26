package tddmicroexercises.leaderboard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tddmicroexercises.leaderboard.TestData.*;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class RaceTest {

    @Test
    public void getPointsShouldCalculateDriverPoints() {
        // setup

        // act

        // verify
        assertEquals(25, TestData.race1.getPoints(driver1));
        assertEquals(18, TestData.race1.getPoints(TestData.driver2));
        assertEquals(15, TestData.race1.getPoints(driver3));
    }


    @Test
    public void resultsShouldCompileRacersPoints(){
        Map<String, Integer> expected = new HashMap<>();
        expected.put(driver1.getName(),25);
        expected.put(driver2.getName(),18);
        expected.put(driver3.getName(),15);

        assertEquals(race1.results(),expected);
    }
}
