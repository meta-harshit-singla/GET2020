package shape;
/**
 * This is an interface which consists of different methods
 * @author Harshit
 */
public interface Shape 
{
    public enum ShapeType
    {
        SQUARE,RECTANGLE,CIRCLE,TRIANGLE;
        public String toString()
        {
            switch(this)
            {
                case SQUARE :
                    return "Square";
                case RECTANGLE :
                    return "Rectangle";
                case CIRCLE :
                    return "Circle";
                case TRIANGLE:
                    return "Triangle";
            }
            return null;
        }
    }
    public double getArea();
    public double getPerimeter();
    public Point getOrigin();
    public boolean isPointEnclosed(Point p);
    public long getTime();
    public String getType();
}