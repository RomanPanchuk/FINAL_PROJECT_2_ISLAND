package wildIsland.animals.herbivore.properties;

import wildIsland.animals.Animal;
import wildIsland.animals.herbivore.*;
import wildIsland.islandProperties.IslandLocation;
import wildIsland.plant.Plant;
import wildIsland.settings.AnimalDiet;
import wildIsland.settings.Settings;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

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

    public void eat(List<? extends Animal> victims, IslandLocation location) {

        AnimalDiet annotationAnimalDiet = this.getClass().getAnnotation(AnimalDiet.class);

        List<? extends Animal> herbivoresList = new CopyOnWriteArrayList<>(victims);
        for (Animal animal : herbivoresList) {
            if (this.eatYesOrNot(annotationAnimalDiet.eatBoar())) {
                animal.toDie(victims, location);
            }
            if (this.eatYesOrNot(annotationAnimalDiet.eatBuffalo())) {
                animal.toDie(victims, location);
            }
            if (this.eatYesOrNot(annotationAnimalDiet.eatCaterpillar())) {
                animal.toDie(victims, location);
            }
            if (this.eatYesOrNot(annotationAnimalDiet.eatDeer())) {
                animal.toDie(victims, location);
            }
            if (this.eatYesOrNot(annotationAnimalDiet.eatDuck())) {
                animal.toDie(victims, location);
            }
            if (this.eatYesOrNot(annotationAnimalDiet.eatGoat())) {
                animal.toDie(victims, location);
            }
            if (this.eatYesOrNot(annotationAnimalDiet.eatHorse())) {
                animal.toDie(victims, location);
            }
            if (this.eatYesOrNot(annotationAnimalDiet.eatMouse())) {
                animal.toDie(victims, location);
            }
            if (this.eatYesOrNot(annotationAnimalDiet.eatRabbit())) {
                animal.toDie(victims, location);
            }
            if (this.eatYesOrNot(annotationAnimalDiet.eatSheep())) {
                animal.toDie(victims, location);
            }
        }

    }

    public void eatPlant(List<Plant> plants, IslandLocation location) {

//            if (plants.size() > 200) {
        if (plants.size() > Plant.maxCount) {
            if (this instanceof Boar) {
                double hunger = ((Boar) this).getHunger();
                while (hunger < Boar.canEat) {
                    hunger++;
                    plants.remove(0);
                }
                ((Boar) this).setHunger(hunger);
            }
            if (this instanceof Buffalo) {
                double hunger = ((Buffalo) this).getHunger();
                while (hunger < Buffalo.canEat) {
                    hunger++;
                    plants.remove(0);
                }
                ((Buffalo) this).setHunger(hunger);
            }
            if (this instanceof Caterpillar) {
                double hunger = ((Caterpillar) this).getHunger();
                while (hunger < Caterpillar.canEat) {
                    hunger++;
                    plants.remove(0);
                }
                ((Caterpillar) this).setHunger(hunger);
            }
            if (this instanceof Deer) {
                double hunger = ((Deer) this).getHunger();
                while (hunger < Deer.canEat) {
                    hunger++;
                    plants.remove(0);
                }
                ((Deer) this).setHunger(hunger);
            }
            if (this instanceof Duck) {
                double hunger = ((Duck) this).getHunger();
                while (hunger < Duck.canEat) {
                    hunger++;
                    plants.remove(0);
                }
                ((Duck) this).setHunger(hunger);
            }
            if (this instanceof Goat) {
                double hunger = ((Goat) this).getHunger();
                while (hunger < Goat.canEat) {
                    hunger++;
                    plants.remove(0);
                }
                ((Goat) this).setHunger(hunger);
            }
            if (this instanceof Horse) {
                double hunger = ((Horse) this).getHunger();
                while (hunger < Horse.canEat) {
                    hunger++;
                    plants.remove(0);
                }
                ((Horse) this).setHunger(hunger);
            }
            if (this instanceof Mouse) {
                double hunger = ((Mouse) this).getHunger();
                while (hunger < Mouse.canEat) {
                    hunger++;
                    plants.remove(0);
                }
                ((Mouse) this).setHunger(hunger);
            }
            if (this instanceof Rabbit) {
                double hunger = ((Rabbit) this).getHunger();
                while (hunger < Rabbit.canEat) {
                    hunger++;
                    plants.remove(0);
                }
                ((Rabbit) this).setHunger(hunger);
            }
            if (this instanceof Sheep) {
                double hunger = ((Sheep) this).getHunger();
                while (hunger < Sheep.canEat) {
                    hunger++;
                    plants.remove(0);
                }
                ((Sheep) this).setHunger(hunger);
            }
        }

    }


}
