package main;
/**
 * This class is used to find LCM(Least common multiple) and HCF(Highest common factor) of two positive numbers
 * @author Harshit
 */
public class FindLcmAndHcf
{
    /**
     * This is a recursive function used to find the HCF of two numbers using Euclid's theorem
     * @param x One of the two positive integers whose HCF is to be found 
     * @param y The other part of the positive integer whose HCF is to be found 
     * @return The HCF of the two numbers
     */
    int findHCF(int x,int y) throws AssertionError
    {
        if(y==0)
            return x;
        else if(x>y)
            return findHCF(y,x%y);
        else
            return findHCF(x,y%x);
    }
    /**
     * This is a function used to find the LCM of two numbers
     * @param x One of the two positive integers whose LCM is to be found 
     * @param y The other part of the positive integer whose LCM is to be found 
     * @return The LCM of the two numbers
     */
    int findLCM(int x,int y) throws AssertionError
    {
        return (x*y)/findHCF(x,y);
    }
}