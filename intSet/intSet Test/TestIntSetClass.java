package main;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestIntSetClass 
{
    @Test
    public void isMemberTest() 
    {
        int array[]=new int[]{2,3,4,5};
        intSet instance=new intSet(array);
        assertEquals(true,instance.isMember(5));
    }
    @Test
    public void sizeTest() 
    {
        int array[]=new int[]{2,3,4,5};
        intSet instance=new intSet(array);
        assertEquals(4,instance.size());
    }
    @Test
    public void isSubSetTest() 
    {
        int array[]=new int[]{2,3,4,5};
        int input[]=new int[]{2,3};
        intSet instance2=new intSet(input);
        intSet instance=new intSet(array);
        assertEquals(true,instance.isSubSet(instance2));
    }
    @Test
    public void getComplementTest() 
    {
        int array[]=new int[]{1,2,3,4,5};
        int expected[]=new int[995];
        int index=0;
        for(int i=6;i<=1000;i++,index++)
        {
            expected[index]=i;
        }
        intSet instance=new intSet(array);
        assertArrayEquals(expected, instance.getComplement());
    }
    @Test
    public void unionTest() 
    {
        int array[]=new int[]{1,2,3,4,5};
        int array2[]=new int[]{2,3,6,7};
        int expected[]=new int[]{1,2,3,4,5,6,7};
        intSet instance=new intSet(array);
        intSet instance1=new intSet(array);
        intSet instance2=new intSet(array2);
        assertArrayEquals(expected, instance.union(instance1,instance2));
    }
}
