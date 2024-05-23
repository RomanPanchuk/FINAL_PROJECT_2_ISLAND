package wildIsland.animals.herbivore;

import wildIsland.animals.herbivore.properties.HerbivoreProperties;
import wildIsland.settings.AnimalDiet;

@AnimalDiet(eatPlants = 100)

public class Rabbit extends HerbivoreProperties {

    public static final double weight = 2;
    public static final int movingSpeed = 2;
    public static final double canEat = 0.45;

    public Rabbit(int xLocation, int yLocation) {
        super(xLocation, yLocation, movingSpeed);
    }

    private double hunger = canEat;

    public double getHunger() {
        return hunger;
    }

    public void setHunger(double hunger) {
        this.hunger = hunger;
    }
}
