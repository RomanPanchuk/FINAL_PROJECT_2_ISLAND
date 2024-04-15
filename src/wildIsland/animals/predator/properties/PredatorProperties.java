package wildIsland.animals.predator.properties;

import wildIsland.animals.Animal;
import wildIsland.animals.predator.*;
import wildIsland.islandProperties.IslandLocation;
import wildIsland.settings.Settings;

import java.util.List;

public abstract class PredatorProperties extends Animal {

    public PredatorProperties(int xLocation, int yLocation, int movingSpeed) {
        super(xLocation, yLocation, movingSpeed);
    }

    public void hunger(IslandLocation islandLocation) {

        if (this instanceof Boa) {
            ((Boa) this).setHunger(((Boa) this).getHunger() - Boa.canEat / Settings.predatorHungerFactor);
        }
        if (this instanceof Bear) {
            ((Bear) this).setHunger(((Bear) this).getHunger() - Bear.canEat / Settings.predatorHungerFactor);
        }
        if (this instanceof Eagle) {
            ((Eagle) this).setHunger(((Eagle) this).getHunger() - Eagle.canEat / Settings.predatorHungerFactor);
        }
        if (this instanceof Fox) {
            ((Fox) this).setHunger(((Fox) this).getHunger() - Fox.canEat / Settings.predatorHungerFactor);
        }
        if (this instanceof Wolf) {
            ((Wolf) this).setHunger(((Wolf) this).getHunger() - Wolf.canEat / Settings.predatorHungerFactor);
        }

    }

    public void checkHealth(List<PredatorProperties> predators, IslandLocation location) {

        if (this instanceof Boa) {
            if (((Boa) this).getHunger() <= 0.5) {
                this.toDie(predators, location);
            }
        }
        if (this instanceof Eagle) {
            if (((Eagle) this).getHunger() <= 0.5) {
                this.toDie(predators, location);
            }
        }
        if (this instanceof Bear) {
            if (((Bear) this).getHunger() <= 0.5) {
                this.toDie(predators, location);
            }
        }
        if (this instanceof Fox) {
            if (((Fox) this).getHunger() <= 0.5) {
                this.toDie(predators, location);
            }
        }
        if (this instanceof Wolf) {
            if (((Wolf) this).getHunger() <= 0.5) {
                this.toDie(predators, location);
            }
        }

    }

}
