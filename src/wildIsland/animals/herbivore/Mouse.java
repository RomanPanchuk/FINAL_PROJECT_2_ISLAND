package wildIsland.animals.herbivore;

import wildIsland.animals.herbivore.properties.HerbivoreProperties;
import wildIsland.settings.AnimalDiet;

@AnimalDiet(eatCaterpillar = 90, eatPlants = 100)

public class Mouse extends HerbivoreProperties {

    public static final double weight = 0.05;
    public static final int movingSpeed = 1;
    public static final double canEat = 0.01;

    public Mouse(int xLocation, int yLocation) {
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
