import wildIsland.islandProperties.IslandLocation;
import wildIsland.islandProperties.IslandProperties;

public record Task(IslandLocation islandLocation, IslandProperties islandProperties) implements Runnable {

    public Task(IslandLocation islandLocation, IslandProperties islandProperties) {
        this.islandLocation = islandLocation;
        this.islandProperties = islandProperties;

        islandLocation.addPlantsToList();
    }

    @Override
    public void run() {
        islandLocation.moveAnimals(islandProperties);
        islandLocation.eating();
        islandLocation.startReproduct();

    }

}