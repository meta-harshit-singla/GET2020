package shape;

import java.util.Date;
import java.util.ArrayList;

public class Square implements Shape
{
    private int intialXCordinate;
    private int intialYCordinate;
    private int width;
    private long time;
    public Square(ArrayList<Integer> parameters, Point p)
    {
        this.intialXCordinate=p.getXCordinate();
        this.intialYCordinate=p.getYCordinate();
        this.width=parameters.get(0);
        Date date=new Date();
        time=date.getTime();
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
     * Used to get the perimeter of square
     */
    @Override
    public double getPerimeter()
    {
        return (4*this.width);
    }
    /**
     * Used to get the area of square
     */
    @Override
    public double getArea()
    {
        return ((this.width)*(this.width));
    }
    /**
     * Used to get the origin of the shape
     */
    @Override
    public boolean isPointEnclosed(Point p) 
    {
        int xDiagonal=intialXCordinate+width;
        int yDiagonal=intialYCordinate+width;
        if((p.getXCordinate()>=intialXCordinate&&p.getXCordinate()<=xDiagonal)&&(p.getYCordinate()>=intialYCordinate&&p.getYCordinate()<=yDiagonal))
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
        return "Square";
    }
}