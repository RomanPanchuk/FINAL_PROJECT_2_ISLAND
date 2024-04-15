package wildIsland.animals.predator;

import wildIsland.animals.predator.properties.PredatorProperties;

public class Fox extends PredatorProperties {

    public static final double weight = 8;
    public static final int movingSpeed = 2;
    public static final double canEat = 2;

    private double hunger = canEat;

    public double getHunger() {
        return hunger;
    }

    public void setHunger(double hunger) {
        this.hunger = hunger;
    }

    public Fox(int xLocation, int yLocation) {
        super(xLocation, yLocation, movingSpeed);
    }
}
