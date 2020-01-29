package shape;

import java.util.ArrayList;
import java.util.Collections;

public class Screen
{
    public static ArrayList<Shape> array=new ArrayList<Shape>();
    public void add(Shape shape)
    {
        array.add(shape);
    }
    public void deleteShape(Shape shape)
    {
        array.remove(shape);
    }
    public void deleteAllShapes(String shapeType)
    {
        for(int i=0;i<array.size();i++)
        {
            if(array.get(i).getType().equalsIgnoreCase(shapeType))
            {
                array.remove(i);
            }
        }
    }
    public ArrayList<Shape> SortByArea()
    {
        AreaCompare areaCompare = new AreaCompare();
        Collections.sort(array, areaCompare);
        return array;
    }
    
    public ArrayList<Shape> SortByPerimeter()
    {
        PerimeterCompare perimeterCompare = new PerimeterCompare();
        Collections.sort(array, perimeterCompare);
        return array;
    }
    
    public ArrayList<Shape> SortByTimestamp()
    {
        return array;
    }
    
    public ArrayList<Shape> SortByOrigin()
    {
        return array;
    }
    
    public ArrayList<Shape> EnclosingPoint(Point p)
    {
        ArrayList<Shape> enclosedPointList = new ArrayList<Shape>();
        for(int i=0;i<array.size();i++)
        {
            if(array.get(i).isPointEnclosed(p))
            {
                enclosedPointList.add(array.get(i));
            }
        }
        return enclosedPointList;
    }   
}