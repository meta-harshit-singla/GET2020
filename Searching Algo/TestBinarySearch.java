package main;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
@RunWith(Parameterized.class)
public class TestBinarySearch 
{
    @Parameters
    public static Collection<Object[]> input()
    {
        return Arrays.asList(new Object[][]
                {
                {new int[]{0,2,4,6,8,10,12,14,16},5,-1},
                {new int[]{0,2,4,6,8,10,12,14,16},6,4},
                {new int[]{0,2,4,6,8,10,12,14,16},16,9}
                });
    }
    private int[] inputArray;
    private int elementToBeSearched;
    private int fExpected;
    public TestBinarySearch(int []array,int element,int expected)
    {
        this.inputArray=array;
        this.fExpected=expected;
        this.elementToBeSearched=element;
    }
    @Test
    public void test()
    {
        Search instance=new Search();
        
        if(instance.binarySearch(inputArray, elementToBeSearched)==-1)
            System.out.println("Array does not contain specified element");
        else
            assertEquals(fExpected,instance.binarySearch(inputArray, elementToBeSearched));   
    }
}