package wildIsland.animals.predator;

import wildIsland.animals.predator.properties.PredatorProperties;
import wildIsland.settings.AnimalDiet;

@AnimalDiet(eatFox = 10, eatRabbit = 90, eatMouse = 90, eatDuck = 80)

public class Eagle extends PredatorProperties {

    public static final double weight = 6;
    public static final int movingSpeed = 3;
    public static final double canEat = 1;

    private double hunger = canEat;

    public double getHunger() {
        return hunger;
    }

    public void setHunger(double hunger) {
        this.hunger = hunger;
    }

    public Eagle(int xLocation, int yLocation) {
        super(xLocation, yLocation, movingSpeed);
    }
}