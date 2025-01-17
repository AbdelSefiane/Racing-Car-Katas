package tddmicroexercises.leaderboard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static tddmicroexercises.leaderboard.TestData.driver1;
import static tddmicroexercises.leaderboard.TestData.driver2;
import static tddmicroexercises.leaderboard.TestData.driver3;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class LeaderboardTest {

    @Test
    public void driverResultsShouldSumThePointsForEachDrivers() {
        // setup

        // act
        Map<String, Integer> results = TestData.sampleLeaderboard1.driverResults();

        // verify
        assertTrue(results.containsKey("Lewis Hamilton"), "results " + results);
        assertEquals(18 + 18 + 25, (int)results.get("Lewis Hamilton"));
    }

    @Test
    public void driverRankingShouldFindTheWinner() {
        // setup

        // act
        List<String> result = TestData.sampleLeaderboard1.driverRankings();

        // verify
        assertEquals("Lewis Hamilton", result.get(0));
    }

    @Test
    public void driverRankingShouldKeepAllDriversWhenSamePoints() {
        // setup
        // bug, drops drivers with same points
        Race winDriver1 = new Race("Australian Grand Prix", driver1, driver2, driver3);
        Race winDriver2 = new Race("Malaysian Grand Prix", driver2, driver1, driver3);
        Leaderboard exEquoLeaderBoard = new Leaderboard(winDriver1, winDriver2);

        // act
        List<String> rankings = exEquoLeaderBoard.driverRankings();

        // verify
        assertEquals(Arrays.asList(driver1.getName(), driver2.getName(), driver3.getName()), rankings);
        // note: the order of driver1 and driver2 is JDK/platform dependent
    }

    @Test
    public void getRaceResultsShouldCompileAllRacesResults() {
        //setup
        Race winDriver1 = new Race("Australian Grand Prix", driver1, driver2, driver3);
        Race winDriver2 = new Race("Malaysian Grand Prix", driver2, driver1, driver3);
        Leaderboard exEquoLeaderBoard = new Leaderboard(winDriver1, winDriver2);

        // act
        List<Map.Entry<String, Integer>> raceResults = exEquoLeaderBoard.getRaceResults();
        // verify
        assertEquals(Arrays.asList(Map.entry(driver3.getName(), 15),
                                   Map.entry(driver1.getName(), 25),
                                   Map.entry(driver2.getName(), 18),
                                   Map.entry(driver3.getName(), 15),
                                   Map.entry(driver1.getName(), 18),
                                   Map.entry(driver2.getName(), 25)
                                  ), raceResults);

    }

}
