package main;
import java.util.Arrays;
/**
 * 
 * @author Harshit
 */
public class Search 
{
    /**
     * This method is used to find the element in an array using linear searching by method of recursion
     * @param array denotes the input array from which the element is to be searched for
     * @param element denotes the element to be searched for
     * @return The position on which the element is located else if the element is not found it returns -1
     */
    int linearSearch(int[] array,int element)
    {
        if(array.length<=0)
            return -1;
        else
        {
            if(array[array.length-1]==element)
                return array.length;
            else
            {
                array=Arrays.copyOfRange(array, 0, array.length-1);
                return linearSearch(array,element);
            }
        }
    }
    /**
     * This method is used as a helper method for binary searching of an element
     * @param array denotes the input array from which the element is to be searched for
     * @param element denotes the element to be searched for
     * @param start denotes the starting index of the array
     * @param end denotes the ending index of the array
     * @return The position on which the element is located else if the element is not found it returns -1
     */
    private int binarySearchHelper(int[] array,int element,int start,int end)
    {
        if(start==end)
        {
            if(array[end]==element)
            {
                return end+1;
            }
            else{
                return -1;
            }
        }
        int mid = (start+end)/2;
        if(array[mid]==element)
        {
            return mid+1;
        }
        else if(array[mid]>element)
        {
            return binarySearchHelper(array,element,start,mid-1);   
        }
        else
        {
            return binarySearchHelper(array,element,mid+1,end);
        }
    }
    /**
     * this method will be called by the user to search an element using binary search
     * @param inputArray denotes the input array from which the element is to be searched for
     * @param element denotes the element to be searched for
     * @return The position on which the element is located else if the element is not found it returns -1
     */
    public int binarySearch(int inputArray[], int element) 
    {
        int start,end;
        start = 0;
        end = inputArray.length-1;
        return binarySearchHelper(inputArray,element,start,end);   
    }
}