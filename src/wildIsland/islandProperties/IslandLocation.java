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

public class IslandLocation {
    private final int x;
    private final int y;

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

    public void eating() {

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
    }

    private int random(int animalCount) {
        return ThreadLocalRandom.current().nextInt(animalCount);
    }

    public void startReproduct() {

        for (int i = 0; i < randomReproductCount(Settings.boarMaxCount / Settings.boarBirthRate); i++) {
            if (herbivores.stream().filter(animal -> animal instanceof Boar).toList().size() > 2) {
                herbivores.add(new Boar(x, y));
            }
        }
        for (int i = 0; i < randomReproductCount(Settings.buffaloMaxCount / Settings.buffaloBirthRate); i++) {
            if (herbivores.stream().filter(animal -> animal instanceof Buffalo).toList().size() > 2) {
                herbivores.add(new Buffalo(x, y));
            }
        }
        for (int i = 0; i < randomReproductCount(Settings.caterpillarMaxCount / Settings.caterpillarBirthRate); i++) {
            if (herbivores.stream().filter(animal -> animal instanceof Caterpillar).toList().size() > 2) {
                herbivores.add(new Caterpillar(x, y));
            }
        }
        for (int i = 0; i < randomReproductCount(Settings.deerMaxCount / Settings.deerBirthRate); i++) {
            if (herbivores.stream().filter(animal -> animal instanceof Deer).toList().size() > 2) {
                herbivores.add(new Deer(x, y));
            }
        }
        for (int i = 0; i < randomReproductCount(Settings.duckMaxCount / Settings.duckBirthRate); i++) {
            if (herbivores.stream().filter(animal -> animal instanceof Duck).toList().size() > 2) {
                herbivores.add(new Duck(x, y));
            }
        }
        for (int i = 0; i < randomReproductCount(Settings.goatMaxCount / Settings.goatBirthRate); i++) {
            if (herbivores.stream().filter(animal -> animal instanceof Goat).toList().size() > 2) {
                herbivores.add(new Goat(x, y));
            }
        }
        for (int i = 0; i < randomReproductCount(Settings.horseMaxCount / Settings.horseBirthRate); i++) {
            if (herbivores.stream().filter(animal -> animal instanceof Horse).toList().size() > 2) {
                herbivores.add(new Horse(x, y));
            }
        }
        for (int i = 0; i < randomReproductCount(Settings.mouseMaxCount / Settings.mouseBirthRate); i++) {
            if (herbivores.stream().filter(animal -> animal instanceof Mouse).toList().size() > 2) {
                herbivores.add(new Mouse(x, y));
            }
        }
        for (int i = 0; i < randomReproductCount(Settings.rabbitMaxCount / Settings.rabbitBirthRate); i++) {
            if (herbivores.stream().filter(animal -> animal instanceof Rabbit).toList().size() > 2) {
                herbivores.add(new Rabbit(x, y));
            }
        }
        for (int i = 0; i < randomReproductCount(Settings.sheepMaxCount / Settings.sheepBirthRate); i++) {
            if (herbivores.stream().filter(animal -> animal instanceof Sheep).toList().size() > 2) {
                herbivores.add(new Sheep(x, y));
            }
        }
        for (int i = 0; i < randomReproductCount(Settings.boaMaxCount / Settings.boeBirthRate); i++) {
            if (predators.stream().filter(animal -> animal instanceof Boa).toList().size() > 2) {
                predators.add(new Boa(x, y));
            }
        }
        for (int i = 0; i < randomReproductCount(Settings.bearMaxCount / Settings.bearBirthRate); i++) {
            if (predators.stream().filter(animal -> animal instanceof Bear).toList().size() > 2) {
                predators.add(new Bear(x, y));
            }
        }
        for (int i = 0; i < randomReproductCount(Settings.eagleMaxCount / Settings.eagleBirthRate); i++) {
            if (predators.stream().filter(animal -> animal instanceof Eagle).toList().size() > 2) {
                predators.add(new Eagle(x, y));
            }
        }
        for (int i = 0; i < randomReproductCount(Settings.foxMaxCount / Settings.foxBirthRate); i++) {
            if (predators.stream().filter(animal -> animal instanceof Fox).toList().size() > 2) {
                predators.add(new Fox(x, y));
            }
        }
        for (int i = 0; i < randomReproductCount(Settings.wolfMaxCount / Settings.wolfBirthRate); i++) {
            if (predators.stream().filter(animal -> animal instanceof Wolf).toList().size() > 2) {
                predators.add(new Wolf(x, y));
            }
        }

    }

    private int randomReproductCount(int animalCount) {
        int returnNumber;
        if (animalCount >= 2) {
            returnNumber = ThreadLocalRandom.current().nextInt(animalCount / 2);
        } else returnNumber = 0;
        return returnNumber;
    }
}
