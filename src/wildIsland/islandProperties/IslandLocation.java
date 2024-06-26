package wildIsland.islandProperties;

import wildIsland.animals.Animal;
import wildIsland.animals.herbivore.*;
import wildIsland.animals.herbivore.properties.HerbivoreProperties;
import wildIsland.animals.predator.*;
import wildIsland.animals.predator.properties.PredatorProperties;
import wildIsland.plant.Plant;
import wildIsland.service.Coordinate;
import wildIsland.settings.Settings;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class IslandLocation {
    private final int x;
    private final int y;

    private final Lock lock = new ReentrantLock(true);

    public Lock getLock() {
        return lock;
    }

    private final List<HerbivoreProperties> herbivores = new ArrayList<>();
    private final List<PredatorProperties> predators = new ArrayList<>();
    private final List<Plant> plants = new ArrayList<>();

    public List<HerbivoreProperties> getHerbivores() {
        return herbivores;
    }

    public List<PredatorProperties> getPredators() {
        return predators;
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public IslandLocation(Coordinate coordinates) {
        this.x = coordinates.getX();
        this.y = coordinates.getY();
    }

    public void moveAnimals(IslandProperties islandProperties) {
        islandProperties.getLock().lock();
        try {
            List<PredatorProperties> predatorsList = new CopyOnWriteArrayList<>(predators);
            List<HerbivoreProperties> herbivoresList = new CopyOnWriteArrayList<>(herbivores);

            for (PredatorProperties predatorProperties : predatorsList) {
                predatorProperties.move(this, IslandProperties.locations);
                predatorProperties.hunger(this);
                predatorProperties.checkHealth(predators, this);
            }
            for (HerbivoreProperties herbivoreProperties : herbivoresList) {
                herbivoreProperties.move(this, IslandProperties.locations);
                herbivoreProperties.hunger(this);
                herbivoreProperties.checkHealth(herbivores, this);
            }
        } finally {
            islandProperties.getLock().unlock();
        }
    }

    public void addAnimal(Animal animal) {

        if (animal instanceof PredatorProperties) {
            predators.add((PredatorProperties) animal);
        }
        if (animal instanceof HerbivoreProperties) {
            herbivores.add((HerbivoreProperties) animal);
        }
    }

    public void addPlantsToList() {
        if (plants.size() < Plant.maxCount) {
            for (int i = 0; i < Plant.maxCount; i++) {
                plants.add(new Plant(1));
            }
        }
    }

    public void addHerbivoresToList() {
        for (int i = 0; i < random(Settings.boarMaxCount); i++) {
            herbivores.add(new Boar(x, y));
        }
        for (int i = 0; i < random(Settings.buffaloMaxCount); i++) {
            herbivores.add(new Buffalo(x, y));
        }
        for (int i = 0; i < random(Settings.caterpillarMaxCount); i++) {
            herbivores.add(new Caterpillar(x, y));
        }
        for (int i = 0; i < random(Settings.deerMaxCount); i++) {
            herbivores.add(new Deer(x, y));
        }
        for (int i = 0; i < random(Settings.duckMaxCount); i++) {
            herbivores.add(new Duck(x, y));
        }
        for (int i = 0; i < random(Settings.goatMaxCount); i++) {
            herbivores.add(new Goat(x, y));
        }
        for (int i = 0; i < random(Settings.horseMaxCount); i++) {
            herbivores.add(new Horse(x, y));
        }
        for (int i = 0; i < random(Settings.mouseMaxCount); i++) {
            herbivores.add(new Mouse(x, y));
        }
        for (int i = 0; i < random(Settings.rabbitMaxCount); i++) {
            herbivores.add(new Rabbit(x, y));
        }
        for (int i = 0; i < random(Settings.sheepMaxCount); i++) {
            herbivores.add(new Sheep(x, y));
        }
    }

    public void addPredatorsToList() {
        for (int i = 0; i < random(Settings.boaMaxCount); i++) {
            predators.add(new Boa(x, y));
        }
        for (int i = 0; i < random(Settings.bearMaxCount); i++) {
            predators.add(new Bear(x, y));
        }
        for (int i = 0; i < random(Settings.eagleMaxCount); i++) {
            predators.add(new Eagle(x, y));
        }
        for (int i = 0; i < random(Settings.foxMaxCount); i++) {
            predators.add(new Fox(x, y));
        }
        for (int i = 0; i < random(Settings.wolfMaxCount); i++) {
            predators.add(new Wolf(x, y));
        }
    }

    public void eating() {
        this.getLock().lock();
        try {
            List<PredatorProperties> predatorsPropertiesList = new CopyOnWriteArrayList<>(predators);
            List<HerbivoreProperties> herbivoresPropertiesList = new CopyOnWriteArrayList<>(herbivores);

            for (PredatorProperties predatorProperties : predatorsPropertiesList) {
                predatorProperties.eat(herbivores, this);
                predatorProperties.checkHealth(predators, this);
            }
            for (HerbivoreProperties herbivoreProperties : herbivoresPropertiesList) {
                herbivoreProperties.eat(herbivores, this);
                herbivoreProperties.eatPlant(plants, this);
                herbivoreProperties.checkHealth(herbivores, this);
            }
        } finally {
            this.getLock().unlock();
        }
    }

    public void startReproduct() {
        this.getLock().lock();
        try {
            IntStream.range(0, randomReproductCount(Settings.boarMaxCount / Settings.boarBirthRate))
                    .filter(i -> herbivores.stream().filter(animal -> animal instanceof Boar).count() > 2)
                    .forEach(i -> herbivores.add(new Boar(x, y)));
            IntStream.range(0, randomReproductCount(Settings.buffaloMaxCount / Settings.buffaloBirthRate))
                    .filter(i -> herbivores.stream().filter(animal -> animal instanceof Buffalo).count() > 2)
                    .forEach(i -> herbivores.add(new Buffalo(x, y)));
            IntStream.range(0, randomReproductCount(Settings.caterpillarMaxCount / Settings.caterpillarBirthRate))
                    .filter(i -> herbivores.stream().filter(animal -> animal instanceof Caterpillar).count() > 2)
                    .forEach(i -> herbivores.add(new Caterpillar(x, y)));
            IntStream.range(0, randomReproductCount(Settings.deerMaxCount / Settings.deerBirthRate))
                    .filter(i -> herbivores.stream().filter(animal -> animal instanceof Deer).count() > 2)
                    .forEach(i -> herbivores.add(new Deer(x, y)));
            IntStream.range(0, randomReproductCount(Settings.duckMaxCount / Settings.duckBirthRate))
                    .filter(i -> herbivores.stream().filter(animal -> animal instanceof Duck).count() > 2)
                    .forEach(i -> herbivores.add(new Duck(x, y)));
            IntStream.range(0, randomReproductCount(Settings.goatMaxCount / Settings.goatBirthRate))
                    .filter(i -> herbivores.stream().filter(animal -> animal instanceof Goat).count() > 2)
                    .forEach(i -> herbivores.add(new Goat(x, y)));
            IntStream.range(0, randomReproductCount(Settings.horseMaxCount / Settings.horseBirthRate))
                    .filter(i -> herbivores.stream().filter(animal -> animal instanceof Horse).count() > 2)
                    .forEach(i -> herbivores.add(new Horse(x, y)));
            IntStream.range(0, randomReproductCount(Settings.mouseMaxCount / Settings.mouseBirthRate))
                    .filter(i -> herbivores.stream().filter(animal -> animal instanceof Mouse).count() > 2)
                    .forEach(i -> herbivores.add(new Mouse(x, y)));
            IntStream.range(0, randomReproductCount(Settings.rabbitMaxCount / Settings.rabbitBirthRate))
                    .filter(i -> herbivores.stream().filter(animal -> animal instanceof Rabbit).count() > 2)
                    .forEach(i -> herbivores.add(new Rabbit(x, y)));
            IntStream.range(0, randomReproductCount(Settings.sheepMaxCount / Settings.sheepBirthRate))
                    .filter(i -> herbivores.stream().filter(animal -> animal instanceof Sheep).count() > 2)
                    .forEach(i -> herbivores.add(new Sheep(x, y)));
            IntStream.range(0, randomReproductCount(Settings.boaMaxCount / Settings.boeBirthRate))
                    .filter(i -> predators.stream().filter(animal -> animal instanceof Boa).count() > 2)
                    .forEach(i -> predators.add(new Boa(x, y)));
            IntStream.range(0, randomReproductCount(Settings.bearMaxCount / Settings.bearBirthRate))
                    .filter(i -> predators.stream().filter(animal -> animal instanceof Bear).count() > 2)
                    .forEach(i -> predators.add(new Bear(x, y)));
            IntStream.range(0, randomReproductCount(Settings.eagleMaxCount / Settings.eagleBirthRate))
                    .filter(i -> predators.stream().filter(animal -> animal instanceof Eagle).count() > 2)
                    .forEach(i -> predators.add(new Eagle(x, y)));
            IntStream.range(0, randomReproductCount(Settings.foxMaxCount / Settings.foxBirthRate))
                    .filter(i -> predators.stream().filter(animal -> animal instanceof Fox).count() > 2)
                    .forEach(i -> predators.add(new Fox(x, y)));
            IntStream.range(0, randomReproductCount(Settings.wolfMaxCount / Settings.wolfBirthRate))
                    .filter(i -> predators.stream().filter(animal -> animal instanceof Wolf).count() > 2)
                    .forEach(i -> predators.add(new Wolf(x, y)));

        } finally {
            this.getLock().unlock();
        }
    }

    private int randomReproductCount(int animalCount) {
        int returnNumber;
        if (animalCount >= 2) {
            returnNumber = ThreadLocalRandom.current().nextInt(animalCount / 2);
        } else returnNumber = 0;
        return returnNumber;
    }

    private int random(int animalCount) {
        return ThreadLocalRandom.current().nextInt(animalCount);
    }
}
