package wildIsland.service;

import wildIsland.animals.herbivore.*;
import wildIsland.animals.predator.*;
import wildIsland.islandProperties.IslandLocation;
import wildIsland.islandProperties.IslandProperties;

public class AnimalStatistics implements Runnable {

    IslandLocation[][] locations;
    IslandProperties island;


    public AnimalStatistics(IslandProperties islandProperties) {
        this.island = islandProperties;
    }

    @Override
    public void run() {
        locations = island.getLocations();

        int total = 0;

        for (IslandLocation[] location : locations) {
            for (IslandLocation value : location) {
                total = total + calculate(value);
            }
        }

        System.out.println(total);
        System.out.println("====================================================================================");
        System.out.println();

    }

    public int calculate(IslandLocation islandLocation) {
        int boar = islandLocation.getHerbivores().stream()
                .filter(animal -> animal instanceof Boar)
                .toList()
                .size();
        int buffalo = islandLocation.getHerbivores().stream()
                .filter(animal -> animal instanceof Buffalo)
                .toList()
                .size();
        int caterpillar = islandLocation.getHerbivores().stream()
                .filter(animal -> animal instanceof Caterpillar)
                .toList()
                .size();
        int deer = islandLocation.getHerbivores().stream()
                .filter(animal -> animal instanceof Deer)
                .toList()
                .size();
        int duck = islandLocation.getHerbivores().stream()
                .filter(animal -> animal instanceof Duck)
                .toList()
                .size();
        int goat = islandLocation.getHerbivores().stream()
                .filter(animal -> animal instanceof Goat)
                .toList()
                .size();
        int horse = islandLocation.getHerbivores().stream()
                .filter(animal -> animal instanceof Horse)
                .toList()
                .size();
        int mouse = islandLocation.getHerbivores().stream()
                .filter(animal -> animal instanceof Mouse)
                .toList()
                .size();
        int rabbit = islandLocation.getHerbivores().stream()
                .filter(animal -> animal instanceof Rabbit)
                .toList()
                .size();
        int sheep = islandLocation.getHerbivores().stream()
                .filter(animal -> animal instanceof Sheep)
                .toList()
                .size();
        int boa = islandLocation.getPredators().stream()
                .filter(animal -> animal instanceof Boa)
                .toList()
                .size();
        int bear = islandLocation.getPredators().stream()
                .filter(animal -> animal instanceof Bear)
                .toList()
                .size();
        int eagle = islandLocation.getPredators().stream()
                .filter(animal -> animal instanceof Eagle)
                .toList()
                .size();
        int fox = islandLocation.getPredators().stream()
                .filter(animal -> animal instanceof Fox)
                .toList()
                .size();
        int wolf = islandLocation.getPredators().stream()
                .filter(animal -> animal instanceof Wolf)
                .toList()
                .size();
        int plants = islandLocation.getPlants().stream()
                .toList()
                .size();

        System.out.print("Total animal count: " + (boar + buffalo + caterpillar + deer + duck + goat + horse + mouse + rabbit + sheep + boa + bear + eagle + fox + " |"));

        if (boar > 0) {
            System.out.print(": 🐗 Boar=" + boar);
        }

        if (buffalo > 0) {
            System.out.print("| \uD83D\uDC03 Buffalo=" + buffalo);
        }

        if (caterpillar > 0) {
            System.out.print("| \uD83D\uDC1B Caterpillar=" + caterpillar);
        }

        if (deer > 0) {
            System.out.print("| \uD83E\uDD8C Deer" + deer);
        }

        if (duck > 0) {
            System.out.print("| \uD83E\uDD86 Duck=" + duck);
        }
        if (goat > 0) {
            System.out.print("| \uD83D\uDC10 Goat=" + goat);
        }
        if (horse > 0) {
            System.out.print("| \uD83D\uDC0E Horse=" + horse);
        }
        if (mouse > 0) {
            System.out.print("| \uD83D\uDC01 Mouse=" + mouse);
        }
        if (rabbit > 0) {
            System.out.print("| \uD83D\uDC07 Rabbit=" + rabbit);
        }
        if (sheep > 0) {
            System.out.print("| \uD83D\uDC11 Sheep=" + sheep);
        }
        if (boa > 0) {
            System.out.print("| \uD83D\uDC0D Boa=" + boa);
        }
        if (bear > 0) {
            System.out.print("| \uD83D\uDC3B Bear=" + bear);
        }
        if (eagle > 0) {
            System.out.print("| \uD83E\uDD85 Eagle=" + eagle);
        }
        if (fox > 0) {
            System.out.print("| \uD83E\uDD8A Fox=" + fox);
        }
        if (wolf > 0) {
            System.out.print("| \uD83D\uDC3A Wolf=" + wolf);
        }
        if (plants > 0) {
            System.out.print("| \uD83C\uDF3E Plants=" + plants);
        }
        System.out.println();

        return (boar + buffalo + caterpillar + deer + duck + goat + horse + mouse + rabbit + sheep + boa + bear + eagle + fox);
    }
}
