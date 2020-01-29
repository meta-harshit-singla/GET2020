package shape;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestShape 
{
    
    @Test
    public void test() 
    { 
        try
        {
            Shape shape1 = ShapeFactory.createShape("Square", new Point(2,2), new ArrayList<Integer>(){{add(5);}});
            Shape shape2 = ShapeFactory.createShape("Rectangle", new Point(2,3), new ArrayList<Integer>(){{add(5);add(6);}});
            Shape shape3 = ShapeFactory.createShape("Circle", new Point(1,2), new ArrayList<Integer>(){{add(2);}});
            Shape shape4 = ShapeFactory.createShape("Square", new Point(2,2), new ArrayList<Integer>(){{add(8);}});
            ArrayList<Shape> expected = new ArrayList<Shape>();
            expected.add(shape1);
            expected.add(shape2);
            expected.add(shape3);
            expected.add(shape4);
            //Used to test the add method
            assertEquals(expected, Screen.array);
            Screen removeInstance = new Screen();
            removeInstance.deleteShape(shape2);
            expected.remove(shape2);
            //Used to remove an object of a single type
            assertEquals(expected, Screen.array);
            removeInstance.deleteAllShapes("Square");
            ArrayList<Shape> expected1 = new ArrayList<Shape>();
            expected1.add(shape3);
            //Used to remove all objects of the given type
            assertEquals(expected1, Screen.array);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
}
