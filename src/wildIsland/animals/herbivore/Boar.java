package wildIsland.animals.herbivore;

import wildIsland.animals.herbivore.properties.HerbivoreProperties;
import wildIsland.settings.AnimalDiet;

@AnimalDiet(eatMouse = 50, eatCaterpillar = 90, eatPlants = 100)

public class Boar extends HerbivoreProperties {
    public static final double weight = 400;
    public static final int movingSpeed = 2;
    public static final double canEat = 50;

    public Boar(int xLocation, int yLocation) {
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
