package wildIsland.animals.predator;

import wildIsland.animals.predator.properties.PredatorProperties;
import wildIsland.settings.AnimalDiet;

@AnimalDiet(eatHorse = 10, eatDeer = 15, eatRabbit = 60, eatMouse = 80, eatGoat = 60, eatSheep = 70,
        eatBoar = 15, eatBuffalo = 10, eatDuck = 40)

public class Wolf extends PredatorProperties {

    public static final double weight = 50;
    public static final int movingSpeed = 3;
    public static final double canEat = 8;

    private double hunger = canEat;

    public double getHunger() {
        return hunger;
    }

    public void setHunger(double hunger) {
        this.hunger = hunger;
    }

    public Wolf(int xLocation, int yLocation) {
        super(xLocation, yLocation, movingSpeed);
    }
}
