package Animal.Aqua.Carnivorous;

import Animal.Aqua.Aqua;

/**
 * 
 * @author Harshit Singla
 * This class represent animal which are Carnivorous and lives in water
 */
public abstract class CarnivorousAqua extends Aqua 
{
    /**
     * 
     * This default constructor set the sub category of the animal to "Carnivorous"
     */
    protected CarnivorousAqua()
    {
        super.subCategory = "Carnivorous";
    }
}