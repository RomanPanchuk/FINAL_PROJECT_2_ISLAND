package wildIsland.animals.herbivore.properties;

import wildIsland.animals.Animal;
import wildIsland.animals.herbivore.*;
import wildIsland.islandProperties.IslandLocation;
import wildIsland.settings.Settings;

import java.util.List;

public abstract class HerbivoreProperties extends Animal {
    public HerbivoreProperties(int xLocation, int yLocation, int movingSpeed) {
        super(xLocation, yLocation, movingSpeed);
    }

    public void hunger(IslandLocation islandLocation) {

        if (this instanceof Boar) {
            ((Boar) this).setHunger(((Boar) this).getHunger() - Boar.canEat / Settings.herbivoreHungerFactor);
        }
        if (this instanceof Buffalo) {
            ((Buffalo) this).setHunger(((Buffalo) this).getHunger() - Buffalo.canEat / Settings.herbivoreHungerFactor);
        }
        if (this instanceof Caterpillar) {
            ((Caterpillar) this).setHunger(((Caterpillar) this).getHunger() - Caterpillar.canEat / Settings.herbivoreHungerFactor);
        }
        if (this instanceof Deer) {
            ((Deer) this).setHunger(((Deer) this).getHunger() - Deer.canEat / Settings.herbivoreHungerFactor);
        }
        if (this instanceof Duck) {
            ((Duck) this).setHunger(((Duck) this).getHunger() - Duck.canEat / Settings.herbivoreHungerFactor);
        }
        if (this instanceof Goat) {
            ((Goat) this).setHunger(((Goat) this).getHunger() - Goat.canEat / Settings.herbivoreHungerFactor);
        }
        if (this instanceof Horse) {
            ((Horse) this).setHunger(((Horse) this).getHunger() - Horse.canEat / Settings.herbivoreHungerFactor);
        }
        if (this instanceof Mouse) {
            ((Mouse) this).setHunger(((Mouse) this).getHunger() - Mouse.canEat / Settings.herbivoreHungerFactor);
        }
        if (this instanceof Rabbit) {
            ((Rabbit) this).setHunger(((Rabbit) this).getHunger() - Rabbit.canEat / Settings.herbivoreHungerFactor);
        }
        if (this instanceof Sheep) {
            ((Sheep) this).setHunger(((Sheep) this).getHunger() - Sheep.canEat / Settings.herbivoreHungerFactor);
        }

    }

    public void checkHealth(List<HerbivoreProperties> herbivores, IslandLocation location) {
        if (this instanceof Boar) {
            if (((Boar) this).getHunger() <= 0) {
                this.toDie(herbivores, location);
            }
        }
        if (this instanceof Buffalo) {
            if (((Buffalo) this).getHunger() <= 0) {
                this.toDie(herbivores, location);
            }
        }
        if (this instanceof Caterpillar) {
            if (((Caterpillar) this).getHunger() <= 0) {
                this.toDie(herbivores, location);
            }
        }
        if (this instanceof Deer) {
            if (((Deer) this).getHunger() <= 0) {
                this.toDie(herbivores, location);
            }
        }
        if (this instanceof Duck) {
            if (((Duck) this).getHunger() <= 0) {
                this.toDie(herbivores, location);
            }
        }
        if (this instanceof Goat) {
            if (((Goat) this).getHunger() <= 0) {
                this.toDie(herbivores, location);
            }
        }
        if (this instanceof Horse) {
            if (((Horse) this).getHunger() <= 0) {
                this.toDie(herbivores, location);
            }
        }
        if (this instanceof Mouse) {
            if (((Mouse) this).getHunger() <= 0) {
                this.toDie(herbivores, location);
            }
        }
        if (this instanceof Rabbit) {
            if (((Rabbit) this).getHunger() <= 0) {
                this.toDie(herbivores, location);
            }
        }
        if (this instanceof Sheep) {
            if (((Sheep) this).getHunger() <= 0) {
                this.toDie(herbivores, location);
            }
        }

    }


}
