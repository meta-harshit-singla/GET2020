package main;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
@RunWith(Parameterized.class)
public class TestSplitArray 
{
    @Parameters
    public static Collection <Object[]> array(){
        return Arrays.asList(new Object[][]{
                {new int[] {1, 1, 1, 2, 1},3},
                {new int[] {2, 1, 1, 2, 1},-1},
                {new int[] {10, 10},1},
        });
    }
    private int fInput[];
    private int fExpected;
    public TestSplitArray(int input[],int expectedOutput)
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
            assertEquals(fExpected,arrayInstance.splitArray(fInput));
        }
        catch(AssertionError e)
        {
            System.out.println(e.getMessage());
        }
    }
}