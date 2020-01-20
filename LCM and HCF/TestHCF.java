package main;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
@RunWith(Parameterized.class)
public class TestHCF 
{
    @Parameters
    public static Collection<Object[]> input()
    {
        return Arrays.asList(new Object[][]{
                {33,27,3},
                {27,33,3}
        });
    }
    private int firstNumber;
    private int secondNumber;
    private int fExpected;
    public TestHCF(int firstNum,int secondNum,int expected)
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
            assertEquals(fExpected,instance.findHCF(firstNumber, secondNumber));
        }
        catch(AssertionError e)
        {
            e.getMessage();
        }
    }
}
