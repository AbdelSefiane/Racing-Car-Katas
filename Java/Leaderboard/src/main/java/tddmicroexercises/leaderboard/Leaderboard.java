package tddmicroexercises.leaderboard;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Leaderboard {

    private final List<Race> races;

    public Leaderboard(Race... races) {
        this.races = Arrays.asList(races);
    }

    public Map<String, Integer> driverResults() {
        Map<String, Integer> results = new HashMap<>();
        List<Entry<String, Integer>> raceResult = getRaceResults();
        //encapsulation
        for (Entry<String, Integer> driver : raceResult) {
            String driverName = driver.getKey();
            int points = driver.getValue();
            results.putIfAbsent(driverName, 0);
            results.put(driverName, results.get(driverName) + points);
        }
        return results;
    }

    protected List<Entry<String, Integer>> getRaceResults() {
        List<Entry<String, Integer>> raceResult = this.races.stream()
                .flatMap((race -> race.results()
                        .entrySet()
                        .stream()))
                .collect(Collectors.toList());
        return raceResult;
    }

    public List<String> driverRankings() {
        Map<String, Integer> results = driverResults();
        List<String> resultsList = new ArrayList<>(results.keySet());
        Collections.sort(resultsList, new DriverByPointsDescendingComparator(results));
        return resultsList;
    }

    private static final class DriverByPointsDescendingComparator implements Comparator<String> {
        private final Map<String, Integer> results;

        private DriverByPointsDescendingComparator(Map<String, Integer> results) {
            this.results = results;
        }

        @Override
        public int compare(String driverName1, String driverName2) {
            return -results.get(driverName1)
                    .compareTo(results.get(driverName2));
        }
    }

}
