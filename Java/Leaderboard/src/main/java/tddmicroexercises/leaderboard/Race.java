package tddmicroexercises.leaderboard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Race {

    private static final Integer[] POINTS = new Integer[]{25, 18, 15};
    private final String name;
    private final List<Racer> results;
    private final Map<Racer, String> driverNames;

    public Race(String name, Racer... drivers) {
        this.name = name;
        this.results = Arrays.asList(drivers);
        this.driverNames = new HashMap<>();
        for (Racer driver : results) {
            String driverName = driver.getName();
            this.driverNames.put(driver, driverName);
        }
    }

    public Map<String, Integer> results() {
        Map<String, Integer> results = new HashMap<>();
            for (Racer driver : this.getResults()) {
                String driverName = driver.getName();
                int points = this.getPoints(driver);
                results.putIfAbsent(driverName, 0);
                results.put(driverName, results.get(driverName) + points);
            }
        return results;
    }

    public int position(Racer driver) {
        return this.results.indexOf(driver);
    }

    public int getPoints(Racer driver) {
        return Race.POINTS[position(driver)];
    }

    public List<Racer> getResults() {
        return results;
    }

    public String getDriverName(Racer driver) {
        return this.driverNames.get(driver);
    }

    @Override
    public String toString() {
        return name;
    }
}
