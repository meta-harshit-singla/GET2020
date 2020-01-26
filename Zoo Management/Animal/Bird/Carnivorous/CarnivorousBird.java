package Animal.Bird.Carnivorous;

import Animal.Bird.Bird;

/**
 * 
 * @author Harshit Singla
 * This class represent Carnivorous Birds
 */
public abstract class CarnivorousBird extends Bird 
{
    /**
     * 
     * default constructor set the sub category of the animal to "Carnivorous"
     */
    protected CarnivorousBird()
    {
        super.subCategory = "Carnivorous";
    }
}