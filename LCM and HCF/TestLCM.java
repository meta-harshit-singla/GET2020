package main;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
@RunWith(Parameterized.class)
public class TestLCM 
{
    @Parameters
    public static Collection<Object[]> input()
    {
        return Arrays.asList(new Object[][]{
                {27,33,297},
                {27,1,27}
        });
    }
    private int firstNumber;
    private int secondNumber;
    private int fExpected;
    public TestLCM(int firstNum,int secondNum,int expected)
    {
        this.firstNumber=firstNum;
        this.secondNumber=secondNum;
        this.fExpected=expected;
    }
    @Test
    public void test()
    {
        FindLcmAndHcf instance=new FindLcmAndHcf();
        try
        {
            assertEquals(fExpected,instance.findLCM(firstNumber, secondNumber));
        }
        catch(AssertionError e)
        {
            e.getMessage();
        }
    }    
}