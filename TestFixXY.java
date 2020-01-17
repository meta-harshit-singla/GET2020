package main;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestFixXY 
{
    @Parameters
    public static Collection <Object[]> array()
    {
        return Arrays.asList(new Object[][]{
                {new int[] {5, 4, 9, 4, 9, 5,},new int[] {9, 4, 5, 4, 5, 9}},
                {new int[] {1, 4, 1, 5},new int[] {1, 4, 5, 1}},
                {new int[] {1, 4, 1, 5, 5, 4, 1},new int[] {1, 4, 5, 1, 1, 4, 5}},
                {new int[]{},new int[]{4,5}}
        });
    }
    private int fInput[];
    private int fExpected[];
    private int xElem;
    private int yElem;
    public TestFixXY(int input[],int expectedOutput[])
    {
        this.xElem=4;
        this.yElem=5;
        this.fInput=input;
        this.fExpected=expectedOutput;
    }
    @Test
    public void test() 
    {
        ArrOperation arrayInstance=new ArrOperation();
        try
        {
            assertArrayEquals(fExpected, arrayInstance.solveFixXY(fInput, xElem, yElem));
        }
        catch(AssertionError e)
        {
            System.out.println(e.getMessage());
        }
    }    
}