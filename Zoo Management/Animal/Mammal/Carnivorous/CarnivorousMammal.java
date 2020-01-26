package Animal.Mammal.Carnivorous;

import Animal.Mammal.Mammal;

/**
 * 
 * @author Harshit Singla
 * This class represent Carnivorous Mammals
 */
abstract class CarnivorousMammal extends Mammal 
{
    /**
     * 
     * default constructor set the sub category of the animal to "Carnivorous"
     */
    protected CarnivorousMammal()
    {
        super.subCategory = "Carnivorous";
    }
}