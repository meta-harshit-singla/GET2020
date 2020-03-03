package Animal.Aqua.Omnivorous;

import Animal.Aqua.Aqua;

/**
 * 
 * @author Harshit Singla
 * This class represent animal which are Omnivorous and lives in water
 */
public abstract class OmnivorousAqua extends Aqua 
{
    /**
     * 
     * This default constructor set the sub category of the animal to "Omnivorous"
     */
    protected OmnivorousAqua()
    {
        super.subCategory = "Omnivorous";
    }
}