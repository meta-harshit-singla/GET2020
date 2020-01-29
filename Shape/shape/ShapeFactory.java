package shape;

import java.util.ArrayList;
/**
 * Used to point the reference to a particular class of shape
 */
public class ShapeFactory
{
    /**
     * Used to create the shape of the given types
     * @param type denotes the type of shape we want to create
     * @param p denotes the object of class point to initialize the origin of the shapes
     * @param listOfParameters denotes the parameters of shape
     * @return the object of the specified shape
     * @throws Exception if the shape doesn't exist
     */
    public static Shape createShape(String type, Point p, ArrayList<Integer> listOfParameters) throws Exception
    {
        Shape shape=null;
        Screen screenInstance=new Screen();
        if(type.equalsIgnoreCase(Shape.ShapeType.TRIANGLE.toString()))
        {
            shape = (Shape) new Triangle(listOfParameters,p);
            screenInstance.add(shape);
        }
        else if(type.equalsIgnoreCase(Shape.ShapeType.SQUARE.toString()))
        {
            shape = (Shape) new Square(listOfParameters,p);
            screenInstance.add(shape);
        }
        else if(type.equalsIgnoreCase(Shape.ShapeType.CIRCLE.toString()))
        {
            shape = (Shape) new Circle(listOfParameters,p);
            screenInstance.add(shape);
        }
        else if(type.equalsIgnoreCase(Shape.ShapeType.RECTANGLE.toString()))
        {
            shape = (Shape) new Rectangle(listOfParameters,p);
            screenInstance.add(shape);
        }
        else
            throw new Exception("Shape does not exist");
        return shape;
    }
}