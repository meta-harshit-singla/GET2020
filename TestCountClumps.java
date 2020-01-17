package main;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestCountClumps 
{
    @Parameters
    public static Collection <Object[]> array()
    {
        return Arrays.asList(new Object[][]{
                {new int[] {1, 2, 2, 3, 4, 4},2},
                {new int[] {1, 1, 2, 1, 1},2},
                {new int[] {1,1,1,1,1},1}       
        });
    }
    private int fInput[];
    private int fExpected;
    public TestCountClumps(int input[],int expectedOutput)
    {
        this.fInput=input;
        this.fExpected=expectedOutput;
    }
    @Test   
    public void test() 
    {
        ArrOperation arrayInstance=new ArrOperation();
        try
        {
            assertEquals(fExpected, arrayInstance.countClumps(fInput));
        }
        catch(AssertionError e)
        {
            System.out.println(e.getMessage());
        }
    }   
}