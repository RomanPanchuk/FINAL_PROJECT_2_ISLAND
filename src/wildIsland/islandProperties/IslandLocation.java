package wildIsland.islandProperties;

import wildIsland.animals.Animal;
import wildIsland.animals.herbivore.properties.HerbivoreProperties;
import wildIsland.animals.predator.properties.PredatorProperties;
import wildIsland.service.Coordinate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class IslandLocation {
    private final int x;
    private final int y;

    private final List<HerbivoreProperties> herbivores = new ArrayList<>();
    private final List<PredatorProperties> predators = new ArrayList<>();

    public List<HerbivoreProperties> getHerbivores() {
        return herbivores;
    }

    public List<PredatorProperties> getPredators() {
        return predators;
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
}
