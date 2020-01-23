package main;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestMaxMirror 
{
    @Parameters
    public static Collection <Object[]> array(){
        return Arrays.asList(new Object[][]{
                {new int[] {1, 4, 5, 3, 5, 4, 1},7},
                {new int[] {1, 2, 1, 4},3},
                {new int[] {7, 1, 4, 9, 7, 4, 1},2},
                {new int[] {1, 2, 3, 8, 9, 3, 2, 1},3}
        });
    }
    private int fInput[];
    private int fExpected;
    public TestMaxMirror(int input[],int expectedOutput)
    {
        this.fInput=input;
        this.fExpected=expectedOutput;
    }
    @Test
    public void testMirror()
    {
        ArrOperation arrayInstance=new ArrOperation();
        try
        {
            assertEquals(fExpected,arrayInstance.maxMirror(fInput));
        }
        catch(AssertionError e)
        {
            System.out.println(e.getMessage());
        }
    }
}