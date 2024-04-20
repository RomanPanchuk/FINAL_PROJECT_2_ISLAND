package wildIsland.Run;

import wildIsland.islandProperties.IslandLocation;
import wildIsland.islandProperties.IslandProperties;
import wildIsland.service.AnimalStatistics;
import wildIsland.service.CultivationPlants;
import wildIsland.service.Task;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Run {
    private static ScheduledExecutorService executorTasks;
    private static ScheduledExecutorService executorCultivationPlants;
    private static ScheduledExecutorService executorAnimalStatistics;

    public static void run() {
        IslandProperties islandProperties = new IslandProperties();
        islandProperties.initialize();
        AnimalStatistics stat = new AnimalStatistics(islandProperties);
        islandProperties.print();

        executorTasks = Executors.newScheduledThreadPool(8);
        executorCultivationPlants = Executors.newScheduledThreadPool(1);
        executorAnimalStatistics = Executors.newScheduledThreadPool(1);


        for (int i = 0; i < islandProperties.getLocations().length; i++) {
            for (int j = 0; j < islandProperties.getLocations()[i].length; j++) {
                IslandLocation location = islandProperties.getLocations()[i][j];
                executorTasks.scheduleWithFixedDelay(new Task(location, islandProperties), 1, 1, TimeUnit.SECONDS);
                executorCultivationPlants.scheduleWithFixedDelay(new CultivationPlants(location), 2, 3, TimeUnit.SECONDS);
            }
        }
        executorAnimalStatistics.scheduleWithFixedDelay(stat, 500, 1000, TimeUnit.MILLISECONDS);
    }
}
