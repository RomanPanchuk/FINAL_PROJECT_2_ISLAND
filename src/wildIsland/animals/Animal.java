package wildIsland.animals;

import wildIsland.settings.Settings;

public class Animal {
    private final int xLocation;
    private final int yLocation;
    private final int xMax = Settings.islandLength;
    private final int yMax = Settings.islandWidth;
    private final int movingSpeed;

    public Animal(int xLocation, int yLocation, int movingSpeed) {
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.movingSpeed = movingSpeed;
    }
}
