package wildIsland.settings;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value= ElementType.TYPE)
@Retention(value= RetentionPolicy.RUNTIME)
public @interface AnimalDiet {
    int eatWolf() default 0;
    int eatAnaconda() default 0;
    int eatFox() default 0;
    int eatBear() default 0;
    int eatEagle() default 0;
    int eatHorse() default 0;
    int eatDeer() default 0;
    int eatRabbit() default 0;
    int eatMouse() default 0;
    int eatGoat() default 0;
    int eatSheep() default 0;
    int eatBoar() default 0;
    int eatBuffalo() default 0;
    int eatDuck() default 0;
    int eatCaterpillar() default 0;
    int eatPlants() default 0;
}
