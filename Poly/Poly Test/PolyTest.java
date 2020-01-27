package main;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
public class PolyTest 
{
    
    @Test
    public void testAddPoly() 
    {
        int []input1=new int[]{2,3};
        int []input2=new int[]{2};
        int expected[]=new int[]{2,5};
        Poly instance1=new Poly(input1);
        Poly instance2=new Poly(input2);
        assertArrayEquals(expected,instance1.addPoly(instance1, instance2));
    }
    @Test
    public void testMultiplyPoly() 
    {
        int []input1=new int[]{2,3};
        int []input2=new int[]{2};
        int expected[]=new int[]{4,6};
        Poly instance1=new Poly(input1);
        Poly instance2=new Poly(input2);
        assertArrayEquals(expected,instance1.multilpyPoly(instance1, instance2));
    }
    @Test
    public void testEvaluatePoly() 
    {
        int []input1=new int[]{2,3};
        float expected=7.0f;
        Poly instance1=new Poly(input1);
        assertEquals(expected,instance1.evaluate(2),0.002);
    }
}