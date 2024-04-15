package wildIsland.animals.herbivore;

import wildIsland.animals.herbivore.properties.HerbivoreProperties;

public class Buffalo extends HerbivoreProperties {

    public static final double weight = 700;
    public static final int movingSpeed = 3;
    public static final double canEat = 100;

    public Buffalo(int xLocation, int yLocation) {
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
