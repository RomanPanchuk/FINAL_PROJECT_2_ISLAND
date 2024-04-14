package wildIsland.islandProperties;

import wildIsland.settings.Settings;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class IslandProperties {
    public static int islandLength = Settings.islandLength;
    public static int islandWidth = Settings.islandWidth;

    public static IslandLocation[][] locations = new IslandLocation[islandLength][islandWidth];
    private final Lock lock = new ReentrantLock(true);
    public Lock getLock() {
        return lock;
    }

    public IslandLocation[][] getLocations() {
        return locations;
    }
}
