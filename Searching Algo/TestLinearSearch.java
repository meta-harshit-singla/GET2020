package main;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
@RunWith(Parameterized.class)
public class TestLinearSearch 
{
    @Parameters
    public static Collection<Object[]> input()
    {
        return Arrays.asList(new Object[][]
                {
                {new int[]{1,2,5,3,6},4,-1},
                {new int[]{1,2,4,3,6,5},4,3},
                {new int[]{1,2,4,3,6,5},2,2}
                });
    }
    private int[] inputArray;
    private int elementToBeSearched;
    private int fExpected;
    public TestLinearSearch(int []array,int element,int expected)
    {
        this.inputArray=array;
        this.fExpected=expected;
        this.elementToBeSearched=element;
    }
    @Test
    public void test()
    {
        Search instance=new Search();
        
        if(instance.linearSearch(inputArray, elementToBeSearched)==-1)
            System.out.println("Array does not contain specified element");
        else
            assertEquals(fExpected,instance.linearSearch(inputArray, elementToBeSearched));   
    }
}