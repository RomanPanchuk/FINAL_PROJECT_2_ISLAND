package wildIsland.animals.herbivore;

import wildIsland.animals.herbivore.properties.HerbivoreProperties;

public class Deer extends HerbivoreProperties {

    public static final double weight = 300;
    public static final int movingSpeed = 4;
    public static final double canEat = 50;

    public Deer(int xLocation, int yLocation) {
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
