package main;
import java.util.ArrayList;
public class ArrOperation
{    
    /**
     * Calculates the size of the largest mirror section found in the input array.Mirror section in an array is a group of contiguous elements such that somewhere in the array, the same group appears in reverse order
     * @param localArray denotes the input array which is to be worked upon
     * @return the size of the largest mirror section found in the input array
     * @throws AssertionError
     */
    public int maxMirror(int[] localArray) throws AssertionError
    {
        int i=0,j=0,copyOfIndexI=0,maxCount=0,count=0;
        if(localArray.length==0)
        {
            throw new AssertionError("Array is empty");
        }
        while(i < localArray.length-1)
        {
            count=0;
            copyOfIndexI=i;
            j=localArray.length-1;
            while(j >= 0)
            {
                if(localArray[copyOfIndexI] == localArray[j])
                {
                    count++;
                    copyOfIndexI++;
                }
                else if(count > 0) 
                {
                    break;
                }
                if(maxCount < count) 
                    maxCount=count;
                j--;
            }
            i++;
        }
        return maxCount;
    }
    /**
     * Calculates the number of clumps in the input array.
     * Clump in an array is a series of 2 or more adjacent elements of the same value
     * @param localArray denotes the input array which is to be worked upon
     * @return  the number of clumps in the input array
     * @throws AssertionError 
     */
    public int countClumps(int[] localArray) throws AssertionError
    {
        boolean match = true;
        int count = 0;
        if(localArray.length==0)
        {
            throw new AssertionError("Array is empty");
        }
        for (int i = 0; i < localArray.length-1; i++) 
        {
            if (localArray[i] == localArray[i+1] && match) 
            {
                match = false;
                count++;
            }
            else if (localArray[i] != localArray[i+1]) 
            {
                match = true;
            }
        }
        return count;
    }
    /**
     * Count the number of occurrences of a particular element in an array
     * @param localArr denotes the input array which is to be worked upon
     * @param element denotes the element which the occurrence is counted to be 
     * @return the number of occurrences of a particular element in an array
     */
    private int countOccurrences(int localArr[],int element)
    {
        int count=0;
        for(int i=0;i<localArr.length;i++)
        {
            if(localArr[i]==element)
                count++;
        }
        return count;
    }
    /**
     * Checks whether element X are adjacent to each other or not
     * @param localArray denotes the input array which is to be worked upon
     * @param xElement denotes the element X
     * @return true if element X is adjacent to each other
     */
    private boolean adjacentXvalues(int localArray[],int xElement)
    {
        boolean flag=false;
        for(int i=0;i<localArray.length-1;i++)
        {
            if(localArray[i]==xElement && localArray[i+1]==xElement)
            {
                flag=true;
                break;
            }
        }
        return flag;
    }
    /**
     *  Rearranging an array that contains exactly the same numbers as the input array, but rearranged so that every X is immediately followed by a Y.X cannot be moved within array, but every other number may move.
     * @param localArray denotes the input array which is to be worked upon
     * @param xElement denotes the element X
     * @param yElement denotes the element Y
     * @return Rearranged array
     * @throws AssertionError
     */
    public int[] solveFixXY(int localArray[],int xElement,int yElement) throws AssertionError
    {
        if(localArray.length==0)
        {
            throw new AssertionError("Array is empty");
        }
        else if(countOccurrences(localArray,xElement)!=countOccurrences(localArray,yElement))
        {
            throw new AssertionError(" there are unequal numbers of X and Y in input array");
        }
        else if(adjacentXvalues(localArray,xElement))
        {
            throw new AssertionError("two adjacents X values are there.");
        }
        else if(localArray[localArray.length-1]==xElement)
        {
            throw new AssertionError(" X occurs at the last index of array");
        }
        ArrayList<Integer> index=new ArrayList<Integer>();
        for(int i=0;i<localArray.length-1;i++)
        {
            if(localArray[i]==xElement)
            {
                for(int j=0;j<localArray.length;j++)
                {
                    if(localArray[j]==yElement && !index.contains(j))
                    {
                        
                        int swapTemporary=localArray[j];
                        localArray[j]=localArray[i+1];
                        localArray[i+1]=swapTemporary;
                        index.add(i+1);  
                        break;
                    }
                }
            }
        }
        return localArray;
    }
    /**
     * Calculates the index if there is a place to split the positive input array so that the sum of the numbers on one side is equal to the sum of the numbers on the other side
     * @param localArray denotes the input array which is to be worked upon
     * @returnReturn the index if there is a place to split the input array else return -1
     * @throws AssertionError
     */
    public int splitArray(int localArray[]) throws AssertionError
    {   
        int leftArraySideSum = 0; 
        if(localArray.length==0)
        {
            throw new AssertionError("Array is empty");
        }
        for (int i = 0 ; i < localArray.length ; i++) 
            leftArraySideSum += localArray[i]; 
        int rightArraySideSum = 0;     
        for (int i = localArray.length-1; i >= 0; i--) 
        { 
            rightArraySideSum += localArray[i]; 
            leftArraySideSum -= localArray[i] ; 
            if (rightArraySideSum == leftArraySideSum) 
                return i ; 
        } 
        return -1; 
    } 
}