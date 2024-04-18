package wildIsland.animals.herbivore;

import wildIsland.animals.herbivore.properties.HerbivoreProperties;
import wildIsland.settings.AnimalDiet;

@AnimalDiet(eatPlants = 100)

public class Goat extends HerbivoreProperties {

    public static final double weight = 60;
    public static final int movingSpeed = 3;
    public static final double canEat = 10;

    public Goat(int xLocation, int yLocation) {
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
