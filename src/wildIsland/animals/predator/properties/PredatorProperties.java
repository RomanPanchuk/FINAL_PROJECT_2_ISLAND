package wildIsland.animals.predator.properties;

import wildIsland.animals.Animal;
import wildIsland.animals.herbivore.*;
import wildIsland.animals.herbivore.properties.HerbivoreProperties;
import wildIsland.animals.predator.*;
import wildIsland.islandProperties.IslandLocation;
import wildIsland.settings.AnimalDiet;
import wildIsland.settings.Settings;

import java.util.List;

public abstract class PredatorProperties extends Animal {

    public PredatorProperties(int xLocation, int yLocation, int movingSpeed) {
        super(xLocation, yLocation, movingSpeed);
    }

    public void hunger(IslandLocation islandLocation) {
        islandLocation.getLock().lock();
        try {
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
        } finally {
            islandLocation.getLock().unlock();
        }

    }

    public void checkHealth(List<PredatorProperties> predators, IslandLocation location) {
        location.getLock().lock();
        try {
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
        } finally {
            location.getLock().unlock();
        }
    }

    public void eat(List<HerbivoreProperties> herbivores, IslandLocation islandLocation) {
        islandLocation.getLock().lock();
        try {
            PredatorProperties predatorProperties = this;

            if (predatorProperties instanceof Boa) {
                double appetite = ((Boa) predatorProperties).getHunger();
                if (appetite < Boa.canEat) {
                    int hunt = predatorProperties.hunt(herbivores, islandLocation);
                    if (hunt > Boa.canEat) {
                        ((Boa) predatorProperties).setHunger((int) Boa.canEat);
                    } else ((Boa) predatorProperties).setHunger(((Boa) predatorProperties).getHunger() + hunt);
                }
            }
            if (predatorProperties instanceof Bear) {
                double appetite = ((Bear) predatorProperties).getHunger();
                if (appetite < Bear.canEat) {
                    int hunt = predatorProperties.hunt(herbivores, islandLocation);
                    if (hunt > Bear.canEat) {
                        ((Bear) predatorProperties).setHunger((int) Bear.canEat);
                    } else ((Bear) predatorProperties).setHunger(((Bear) predatorProperties).getHunger() + hunt);
                }
            }
            if (predatorProperties instanceof Eagle) {
                double appetite = ((Eagle) predatorProperties).getHunger();
                if (appetite < Eagle.canEat) {
                    int hunt = predatorProperties.hunt(herbivores, islandLocation);
                    if (hunt > Eagle.canEat) {
                        ((Eagle) predatorProperties).setHunger((int) Eagle.canEat);
                    } else ((Eagle) predatorProperties).setHunger(((Eagle) predatorProperties).getHunger() + hunt);
                }
            }
            if (predatorProperties instanceof Fox) {
                double appetite = ((Fox) predatorProperties).getHunger();
                if (appetite < Fox.canEat) {
                    int hunt = predatorProperties.hunt(herbivores, islandLocation);
                    if (hunt > Fox.canEat) {
                        ((Fox) predatorProperties).setHunger((int) Fox.canEat);
                    } else ((Fox) predatorProperties).setHunger(((Fox) predatorProperties).getHunger() + hunt);
                }
            }
            if (predatorProperties instanceof Wolf) {
                double appetite = ((Wolf) predatorProperties).getHunger();
                if (appetite < Wolf.canEat) {
                    int hunt = predatorProperties.hunt(herbivores, islandLocation);
                    if (hunt > Wolf.canEat) {
                        ((Wolf) predatorProperties).setHunger((int) Wolf.canEat);
                    } else ((Wolf) predatorProperties).setHunger(((Wolf) predatorProperties).getHunger() + hunt);
                }
            }
        } finally {
            islandLocation.getLock().unlock();
        }
    }

    public int hunt(List<HerbivoreProperties> herbivoreProperties, IslandLocation islandLocation) {
        int hungerCount = 0;
        PredatorProperties predatorProperties = this;
        islandLocation.getLock().lock();
        try {
            AnimalDiet annotationAnimalDiet = predatorProperties.getClass().getAnnotation(AnimalDiet.class);

            if (herbivoreProperties.size() > 0) {
                HerbivoreProperties properties = herbivoreProperties.get(random(herbivoreProperties.size()));

                if (predatorProperties.eatYesOrNot(annotationAnimalDiet.eatBoar()) && properties instanceof Boar) {
                    properties.toDie(herbivoreProperties, islandLocation);
                    hungerCount = (int) Bear.weight;
                }
                if (predatorProperties.eatYesOrNot(annotationAnimalDiet.eatBuffalo()) && properties instanceof Buffalo) {
                    properties.toDie(herbivoreProperties, islandLocation);
                    hungerCount = (int) Buffalo.weight;
                }
                if (predatorProperties.eatYesOrNot(annotationAnimalDiet.eatCaterpillar()) && properties instanceof Caterpillar) {
                    properties.toDie(herbivoreProperties, islandLocation);
                    hungerCount = (int) Caterpillar.weight;
                }
                if (predatorProperties.eatYesOrNot(annotationAnimalDiet.eatDeer()) && properties instanceof Deer) {
                    properties.toDie(herbivoreProperties, islandLocation);
                    hungerCount = (int) Deer.weight;
                }
                if (predatorProperties.eatYesOrNot(annotationAnimalDiet.eatDuck()) && properties instanceof Duck) {
                    properties.toDie(herbivoreProperties, islandLocation);
                    hungerCount = (int) Duck.weight;
                }
                if (predatorProperties.eatYesOrNot(annotationAnimalDiet.eatGoat()) && properties instanceof Goat) {
                    properties.toDie(herbivoreProperties, islandLocation);
                    hungerCount = (int) Goat.weight;
                }
                if (predatorProperties.eatYesOrNot(annotationAnimalDiet.eatHorse()) && properties instanceof Horse) {
                    properties.toDie(herbivoreProperties, islandLocation);
                    hungerCount = (int) Horse.weight;
                }
                if (predatorProperties.eatYesOrNot(annotationAnimalDiet.eatMouse()) && properties instanceof Mouse) {
                    properties.toDie(herbivoreProperties, islandLocation);
                    hungerCount = 1;
                }
                if (predatorProperties.eatYesOrNot(annotationAnimalDiet.eatRabbit()) && properties instanceof Rabbit) {
                    properties.toDie(herbivoreProperties, islandLocation);
                    hungerCount = (int) Rabbit.weight;
                }
                if (predatorProperties.eatYesOrNot(annotationAnimalDiet.eatSheep()) && properties instanceof Sheep) {
                    properties.toDie(herbivoreProperties, islandLocation);
                    hungerCount = (int) Sheep.weight;
                }
            }
        } finally {
            islandLocation.getLock().unlock();
        }
        return hungerCount;
    }
}