package main;
import static org.junit.Assert.*;
import org.junit.Test;
public class TestSparseMatrices 
{    
    @Test
    public void testTranspose() 
    {
        SparseMatrices instance1=new SparseMatrices(new int[][]{{2,0,0},{4,0,0}});
        int[][] expectedMatrix=new int[][]{{2,4},{0,0},{0,0}};
        int[][] transposedMatrix=instance1.transpose();
        assertArrayEquals(expectedMatrix,transposedMatrix);
    }  
    @Test
    public void testIsSymmetric() 
    {
        try
        {
            SparseMatrices instance1=new SparseMatrices(new int[][]{{2,0,0},{4,0,0}});
            assertEquals(false,instance1.isSymmetric());
        }
        catch(AssertionError e)
        {
            System.out.println(e.getMessage());
        }
        try
        {
            SparseMatrices instance2=new SparseMatrices(new int[][]{{0,3,0,0},{3,0,4,0},{0,4,0,0},{0,0,0,0}});
            assertEquals(true,instance2.isSymmetric());
        }
        catch(AssertionError e)
        {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void testAddMatrices() 
    {
        try
        {
            SparseMatrices instance1=new SparseMatrices(new int[][]{{0,10,0,12},{0,0,0,0},{0,0,5,0},{15,12,0,0}});
            SparseMatrices instance2=new SparseMatrices(new int[][]{{0,0,8,0},{0,0,0,23},{0,0,9,0},{20,25,0,0}});
            int [][]expected=new int[][]{{0,10,8,12},{0,0,0,23},{0,0,14,0},{35,37,0,0}};
            assertArrayEquals(expected,instance1.addMatrices(instance2));
        }
        catch(AssertionError e)
        {
            System.out.println(e.getMessage());
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        try
        {
            SparseMatrices instance1=new SparseMatrices(new int[][]{{0,10,0,12},{0,0,0,0},{0,0,5,0},{15,12,0,0}});
            SparseMatrices instance2=new SparseMatrices(new int[][]{{0,0,8,0},{0,0,0,23},{0,0,9,0},{20,25,0,0}});
            int [][]expected=new int[][]{{0,10,8,12},{0,0,0,23},{0,0,14,0},{35,37,0,0}};
            assertArrayEquals(expected,instance1.addMatrices(instance2));
        }
        catch(AssertionError e)
        {
            System.out.println(e.getMessage());
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void testMultiplyMatrices() 
    {
        try
        {
            SparseMatrices instance1=new SparseMatrices(new int[][]{{0,10,0,12},{0,0,0,0},{0,0,5,0},{15,12,0,0}});
            SparseMatrices instance2=new SparseMatrices(new int[][]{{0,0,8,0},{0,0,0,23},{0,0,9,0},{20,25,0,0}});
            int [][]expected=new int[][]{{240,300,0,230},{0,0,0,0},{0,0,45,0},{0,0,120,276}};
            assertArrayEquals(expected,instance1.multiplyMatrices(instance2));
        }
        catch(AssertionError e)
        {
            System.out.println(e.getMessage());
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        try
        {
            SparseMatrices instance1=new SparseMatrices(new int[][]{{0,10,0,12},{0,0,0,0},{0,0,5,0},{15,12,0,0}});
            SparseMatrices instance2=new SparseMatrices(new int[][]{{0,0,8,0},{0,0,0,23},{0,0,9,0}});
            int [][]expected=new int[][]{{0,10,8,12},{0,0,0,23},{0,0,14,0},{35,37,0,0}};
            assertArrayEquals(expected,instance1.multiplyMatrices(instance2));
        }
        catch(AssertionError e)
        {
            System.out.println(e.getMessage());
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}