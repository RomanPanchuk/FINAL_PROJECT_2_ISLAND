package wildIsland.animals.predator;

import wildIsland.animals.predator.properties.PredatorProperties;

public class Boa extends PredatorProperties {

    public static final double weight = 15;
    public static final int movingSpeed = 1;
    public static final double canEat = 3;


    private double hunger = canEat;

    public double getHunger() {
        return hunger;
    }

    public void setHunger(double hunger) {
        this.hunger = hunger;
    }

    public Boa(int xLocation, int yLocation) {
        super(xLocation, yLocation, movingSpeed);
    }
}
