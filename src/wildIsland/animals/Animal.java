package wildIsland.animals;

import wildIsland.animals.herbivore.*;
import wildIsland.animals.herbivore.properties.HerbivoreProperties;
import wildIsland.animals.predator.*;
import wildIsland.animals.predator.properties.PredatorProperties;
import wildIsland.islandProperties.IslandLocation;
import wildIsland.islandProperties.IslandProperties;
import wildIsland.settings.Settings;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Animal {
    private final int xLocation;
    private final int yLocation;
    private final int xMax = Settings.islandLength;
    private final int yMax = Settings.islandWidth;
    private final int movingSpeed;

    public Animal(int xLocation, int yLocation, int movingSpeed) {
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.movingSpeed = movingSpeed;
    }

    public void move(IslandLocation islandLocation, IslandLocation[][] locations) {
        islandLocation.getLock().lock();
        try {
            int[] newCoordinates = this.getNewCoordinates();
            if (isLocationFree(islandLocation)) {
                locations[newCoordinates[0]][newCoordinates[1]].addAnimal(this);
                if (this instanceof PredatorProperties) {
                    islandLocation.getPredators().remove(this);
                }
                if (this instanceof HerbivoreProperties) {
                    islandLocation.getHerbivores().remove(this);
                }
            } else move(islandLocation, locations);
        } finally {
            islandLocation.getLock().unlock();
        }
    }

    private boolean isLocationFree(IslandLocation islandLocation) {
        int maxCount = 0;
        boolean returnValue;
        if (this instanceof Boar) {
            maxCount = Settings.boarMaxCount;
        }
        if (this instanceof Buffalo) {
            maxCount = Settings.buffaloMaxCount;
        }
        if (this instanceof Caterpillar) {
            maxCount = Settings.caterpillarMaxCount;
        }
        if (this instanceof Deer) {
            maxCount = Settings.deerMaxCount;
        }
        if (this instanceof Duck) {
            maxCount = Settings.duckMaxCount;
        }
        if (this instanceof Goat) {
            maxCount = Settings.goatMaxCount;
        }
        if (this instanceof Horse) {
            maxCount = Settings.horseMaxCount;
        }
        if (this instanceof Mouse) {
            maxCount = Settings.mouseMaxCount;
        }
        if (this instanceof Rabbit) {
            maxCount = Settings.rabbitMaxCount;
        }
        if (this instanceof Sheep) {
            maxCount = Settings.sheepMaxCount;
        }
        if (this instanceof Boa) {
            maxCount = Settings.boaMaxCount;
        }
        if (this instanceof Bear) {
            maxCount = Settings.bearMaxCount;
        }
        if (this instanceof Eagle) {
            maxCount = Settings.eagleMaxCount;
        }
        if (this instanceof Fox) {
            maxCount = Settings.foxMaxCount;
        }
        if (this instanceof Wolf) {
            maxCount = Settings.wolfMaxCount;
        }

        int herbivoresCountOnLocation = (int) islandLocation.getHerbivores().stream()
                .filter(this::equals)
                .count();
        int predatorsCountOnLocation = (int) islandLocation.getPredators().stream()
                .filter(this::equals)
                .count();

        if (this instanceof PredatorProperties && predatorsCountOnLocation < maxCount) {
            returnValue = true;
        } else {
            returnValue = this instanceof HerbivoreProperties && herbivoresCountOnLocation < maxCount;
        }
        return returnValue;
    }

    private int[] getNewCoordinates() {
        int[] returnCoordinates = new int[2];
        int direction = ThreadLocalRandom.current().nextInt(4);
        int newXLocation;
        int newYLocation;

        if (direction == 0) {
            newXLocation = xLocation + movingSpeed;
            newYLocation = yLocation;
        } else if (direction == 1) {
            newXLocation = xLocation;
            newYLocation = yLocation + movingSpeed;
        } else if (direction == 2) {
            newXLocation = xLocation - movingSpeed;
            newYLocation = yLocation;
        } else {
            newXLocation = xLocation;
            newYLocation = yLocation - movingSpeed;
        }
        int x = (newXLocation + xMax) % xMax;
        int y = (newYLocation + yMax) % yMax;
        returnCoordinates[0] = x;
        returnCoordinates[1] = y;

        return returnCoordinates;
    }

    public void toDie(List<? extends Animal> animals, IslandLocation islandLocation) {
        islandLocation.getLock().lock();
        try {
            animals.remove(this);
        } finally {
            islandLocation.getLock().unlock();
        }
    }

    public int random(int count) {
        return ThreadLocalRandom.current().nextInt(count);
    }

    public boolean eatYesOrNot(int chance) {
        int random = ThreadLocalRandom.current().nextInt(101);
        return random <= chance;
    }
}
