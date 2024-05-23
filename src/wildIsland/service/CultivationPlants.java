package wildIsland.service;

import wildIsland.islandProperties.IslandLocation;
import wildIsland.plant.Plant;

import java.util.concurrent.ThreadLocalRandom;

public class CultivationPlants implements Runnable {

    public static int maxCount = Plant.maxCount;
    private final IslandLocation islandLocation;

    public CultivationPlants(IslandLocation location) {
        this.islandLocation = location;
    }

    @Override
    public void run() {
        growPlant();
    }

    public void growPlant() {
        for (int i = 0; i < random(maxCount); i++) {
            islandLocation.getPlants().add(new Plant(1));
        }
    }

    private int random(int maxCount) {
        return ThreadLocalRandom.current().nextInt(maxCount);
    }
}