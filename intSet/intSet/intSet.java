package main;
import java.util.Arrays;
public class intSet 
{    
    static final int CONSTANT=1000;
    static final private int universalSet[]=new int[CONSTANT];
    /**
     * This static block helps to initialize
     */
    static
    {
        for(int i=0;i<universalSet.length;i++)
        {
            universalSet[i]=i+1;
        }
    }
    private int[] arraySet;
    /**
     * Parameterized Constructor used to initialize the input set by the user 
     * @param inputSet denotes the set which the user will initialize
     */
    public intSet(int inputSet[]) 
    {
        try
        {
            validateSet(inputSet);
        }
        catch(AssertionError e)
        {
            System.out.println(e.getMessage());
        }
        this.arraySet=inputSet;
    }
    /**
     * Used to validate the input
     * @param inputSet denotes the set entered by the user
     */
    private void validateSet(int[] inputSet)
    {
        Arrays.sort(inputSet);
        for(int i=0;i<inputSet.length;i++)
        {
            if(!(inputSet[i]>=1 && inputSet[i]<=1000))
            {
                throw new AssertionError("Elements not in range");
            }
            else if(inputSet.length<=0)
            {
                throw new AssertionError("Array is empty");
            }
        }
        for(int i=0;i<inputSet.length-1;i++)
        {
            if(inputSet[i]==inputSet[i+1])
            {
                throw new AssertionError("Elements in the set are repeated");
            }
        }
    }
    /**
     * This method is used to check whether x is an element of the universal set or not
     * @param x denotes the element which is to be checked
     * @return true if element is present in the set else false
     */
    public boolean isMember(int x)
    {
        for(int i=0;i<arraySet.length;i++)
        {
            if(arraySet[i]==x)
                return true;
        }
        return false;
    }
    /**
     * Used to return the size of the set entered by the user
     * @return the size of the set entered by the user
     */
    public int size()
    {
        return arraySet.length;
    }
    /**
     * Used to check whether s is a subset of the set entered by the user
     * @param s denotes the set which is to be checked that whether it is a subset or not
     * @return true if it is a subset else return false
     */
    public boolean isSubSet(intSet s)
    {
        boolean flag=true;
        for(int i=0;i<s.arraySet.length;i++)
        {
            flag=true;
            for(int j=0;j<this.arraySet.length;j++)
            {
                if(s.arraySet[i]!=this.arraySet[j])
                {
                    flag=false;
                }
                else
                {
                    flag=true;
                    break;
                }
            }
            if(flag)
            {
                flag=true;
            }
            else
                break;
        }
        return flag;
    }
    /**
     * Used to calculate the complement of the inputed set by the user comparing it by the universal set
     * @return the array consisting of the elements of the complement set 
     */
    public int[] getComplement()
    {
        int []complementArray=new int[universalSet.length-arraySet.length];
        boolean flag=true;
        int c=-1;
        for(int i=0;i<universalSet.length;i++)
        {
            flag=false;
            for(int j=0;j<arraySet.length;j++)
            {
                if(universalSet[i]!=arraySet[j])
                {
                    flag=true;
                }
                else 
                {
                    flag=false;
                    break;
                }
            }
            if(flag)
                complementArray[++c]=universalSet[i];
        }
        return complementArray;
    }
    /**
     * Used to calculate the union of two sets
     * @param s1 denotes the first set
     * @param s2 denotes the second set
     * @return the array with elements of the union of both the subsets
     */
    public int[] union(intSet s1,intSet s2)
    {
        int count=0;
        for(int i=0;i<s1.size();i++)
        {
            for(int j=0;j<s2.size();j++)
            {
                if(s1.arraySet[i]==s2.arraySet[j])
                {
                   count++;
                }
            }
        }  
        int unionArray[]=new int[s1.arraySet.length+s2.arraySet.length-count];
        count=-1;
        Arrays.sort(s1.arraySet);
        Arrays.sort(s2.arraySet);
        boolean flag=true;
        for(int i=0;i<s1.size();i++)
        {
            flag=true;
            for(int j=0;j<s2.size();j++)
            {
                if(s1.arraySet[i]!=s2.arraySet[j])
                {
                    flag=true;
                }
                else 
                {
                    flag=false;
                    break;
                }
            }
            if(flag)
                unionArray[++count]=s1.arraySet[i];
        }
        for(int i=0;i<s2.size();i++)
            unionArray[++count]=s2.arraySet[i];
        Arrays.sort(unionArray);
        return unionArray;
    }
}