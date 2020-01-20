package main;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.ParametersSuppliedBy;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
@RunWith(Parameterized.class)
public class NQueenTest 
{
    @Parameters
    public static Collection<Object[]> array()
    {
        return Arrays.asList(new Object[][]
                {
                {new int[][] {{0,0,0},{0,0,0},{0,0,0}},0,3,false},
                {new int[][] {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}},0,4,true},
                {new int[][] {{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}},0,8,true}
                });
    }
    private int[][] inputArray;
    private int startRow;
    private int dimensionOfMatrix;
    private Boolean fExpected;
    public NQueenTest(int [][]arr,int start,int numberOfRow,Boolean expected)
    {
        this.inputArray=arr;
        this.dimensionOfMatrix=numberOfRow;
        this.startRow=start;
        this.fExpected=expected;
    }
    @Test
    public void test() 
    {
        NQueenProblem nQueenInstance=new NQueenProblem();
        
        if(nQueenInstance.nOueen(inputArray,startRow,dimensionOfMatrix))
        {
            nQueenInstance.print(dimensionOfMatrix);
        }
        else
            assertEquals(fExpected,nQueenInstance.nOueen(inputArray,startRow,dimensionOfMatrix));
    }
}