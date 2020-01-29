package shape;

import java.util.Date;
import java.util.ArrayList;

public class Triangle implements Shape
{
    private int intialXCordinate;
    private int intialYCordinate;
    private int length1,length2,length3;
    private long time;
    public Triangle(ArrayList<Integer> parameters, Point p)
    {
        this.length1 = parameters.get(0);
        this.length2 = parameters.get(1);
        this.length3 = parameters.get(2);
        this.intialXCordinate = p.getXCordinate();
        this.intialYCordinate = p.getYCordinate();
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
     * Used to get the perimeter of triangle
     */
    @Override
    public double getPerimeter()
    {
        return length1+length2+length3;
    }
    /**
     * Used to get the area of triangle
     */
    @Override
    public double getArea()
    {
        int perimeter=(int)getPerimeter()/2;
        return (Math.sqrt(perimeter*(perimeter-length1)*(perimeter-length2)*(perimeter-length3)));
    }
    /**
     * Used to get the origin of the shape
     */
    @Override
    public boolean isPointEnclosed(Point p) 
    {
        int x,x1,x2,y,y1,y2;
        x=p.getXCordinate();
        y=p.getYCordinate();
        x2=this.intialXCordinate+length1;
        y2=this.intialYCordinate;
        x1=Math.abs((int)(Math.pow(length2, 2)-Math.pow(length3, 2)+Math.pow(x2, 2)-Math.pow(intialXCordinate, 2))/(2*length1));
        y1=(int)(Math.pow(length2, 2)+Math.pow(intialYCordinate, 2)-Math.pow((x1-this.intialXCordinate),2));
        double Area=getAreaWithPoints(intialXCordinate, x1, x2, intialYCordinate, y1, y2);
        double Area1=getAreaWithPoints(x, x1, x2, y, y1, y2);
        double Area2=getAreaWithPoints(intialXCordinate, x, x2, intialYCordinate, y, y2);
        double Area3=getAreaWithPoints(intialXCordinate, x1, x, intialYCordinate, y1, y);
        if(Area==(Area1+Area2+Area3))
            return true;
        else
            return false;
    }
    private double getAreaWithPoints(int x1, int x2, int x3, int y1, int y2, int y3)
    {
        return Math.abs((x1*(y2-y3) + x2*(y3-y1)+x3*(y1-y2))/2.0); 
    }
    public long getTime()
    {
        return time;
    }
    @Override
    public String getType() 
    {
        return "Triangle";
    }
}