package wildIsland.animals.predator;

import wildIsland.animals.predator.properties.PredatorProperties;

public class Bear extends PredatorProperties {

    public static final double weight = 500;
    public static final int movingSpeed = 2;
    public static final double canEat = 80;


    private double hunger = canEat;

    public double getHunger() {
        return hunger;
    }

    public void setHunger(double hunger) {
        this.hunger = hunger;
    }

    public Bear(int xLocation, int yLocation) {
        super(xLocation, yLocation, movingSpeed);
    }
}
