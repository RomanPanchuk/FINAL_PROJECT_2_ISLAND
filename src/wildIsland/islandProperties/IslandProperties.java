package wildIsland.islandProperties;

import wildIsland.service.AnimalStatistics;
import wildIsland.service.Coordinate;
import wildIsland.settings.Settings;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class IslandProperties {
    public static int islandLength = Settings.islandLength;
    public static int islandWidth = Settings.islandWidth;

    public static IslandLocation[][] locations = new IslandLocation[islandLength][islandWidth];

    public IslandLocation[][] getLocations() {
        return locations;
    }

    public void initialize() {
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {

                locations[i][j] = new IslandLocation(new Coordinate(i, j));
                locations[i][j].addHerbivoresToList();
                locations[i][j].addPredatorsToList();
                locations[i][j].addPlantsToList();
            }
        }
    }

    public void print() {
        int total = 0;
        AnimalStatistics statistics = new AnimalStatistics(this);
        for (IslandLocation[] location : locations) {
            for (IslandLocation value : location) {
                total = total + statistics.calculate(value);
            }
        }
        System.out.println("Total animal count: " + total);
    }
}


