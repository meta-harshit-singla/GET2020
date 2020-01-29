package shape;

import java.util.ArrayList;
import java.util.Date;

public class Circle implements Shape
{
    private int radius;
    private int intialXCordinate;
    private int intialYCordinate;
    private long time;
    public Circle(ArrayList<Integer> radiusArray,Point p)
    {
        this.intialXCordinate=p.getXCordinate();
        this.intialYCordinate=p.getYCordinate();
        this.radius=radiusArray.get(0);
        Date date=new Date();
        time=date.getTime();
    }
    /**
     * Used to get the area of circle
     */
    @Override
    public double getArea() 
    {
        return Math.PI*radius*radius;
    }
    /**
     * Used to get the perimeter of circle
     */
    @Override
    public double getPerimeter() 
    {
        return 2*Math.PI*radius;
    }
    /**
     * Used to get the origin of the shape
     */
    @Override
    public Point getOrigin() 
    {
        Point instance=new Point(this.intialXCordinate,this.intialYCordinate);
        return instance;
    }
    /**
     * Checks whether the specific point is enclosed in a shape or not
     */
    @Override
    public boolean isPointEnclosed(Point p) 
    {
        double distance= ((Math.pow((p.getXCordinate()-this.intialXCordinate),2)))+(Math.pow((p.getYCordinate()-this.intialYCordinate),2));
        if(Math.sqrt(distance)<=radius)
            return true;
        else
            return false;
    }
    @Override
    public long getTime()
    {
        return time;
    }
    @Override
    public String getType() 
    {
        return "Circle";
    }
}