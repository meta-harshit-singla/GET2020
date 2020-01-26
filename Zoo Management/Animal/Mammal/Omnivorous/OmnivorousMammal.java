package Animal.Mammal.Omnivorous;
import Animal.Mammal.Mammal;
/**
 * 
 * @author Harshit Singla
 * This class represent Omnivorous Mammals
 */
public abstract class OmnivorousMammal extends Mammal 
{
    /**
     * 
     * default constructor set the sub category of the animal to "Omnivorous"
     */
    protected OmnivorousMammal()
    {
        super.subCategory = "Omnivorous";
    }
}