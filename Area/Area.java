package main;
import java.util.Scanner;
/**
 * @author Harshit
 *This class computes areas of different shapes
 */
public class Area 
{
    /**
     * Calculates the area of a triangle
     * @param triangleWidth denotes the base of a triangle with positive input
     * @param triangleHeight denotes the height of a triangle with positive input
     * @return the calculated area of the triangle
     * @throws ArithmeticException
     */
    double calculateAreaOfTriangle(double triangleWidth,double triangleHeight) throws ArithmeticException
    {
        return ((triangleWidth*triangleHeight)/2);
    }
    /**
     * Calculates the area of a rectangle
     * @param rectangleWidth denotes the length of a rectangle with positive input
     * @param rectangleHeight denotes the breadth of a rectangle with positive input
     * @return the calculated area of the rectangle
     * @throws ArithmeticException
     */
    double calculateAreaOfRectangle(double rectangleWidth,double rectangleHeight) throws ArithmeticException
    {
        return (rectangleWidth*rectangleHeight);
    }
    /**
     * Calculates the area of a square
     * @param squareWidth denotes the side of a square with positive input
     * @return the calculated area of the square
     * @throws ArithmeticException
     */
    double calculateAreaOfSquare(double squareWidth) throws ArithmeticException
    {
        return (squareWidth*squareWidth);
    }
    /**
     * Calculates the area of a circle
     * @param radius denotes the radius of a circle with positive input
     * @return the calculated area of the circle
     * @throws ArithmeticException
     */
    double calculateAreaOfCircle(double radius) throws ArithmeticException
    {
        return ((Math.PI)*(radius*radius));
    }
    public static void main(String[] args) 
    {
        Scanner input=new Scanner(System.in);
        double width=0.0,height=0.0,radius=0.0;
        Area calculate=new Area();
        while(true)
        {
            System.out.println("\nMenu");
            System.out.println("1.Calculate area of Triangle");
            System.out.println("2.Calculate area of Rectangle");
            System.out.println("3.Calculate area of Square");
            System.out.println("4.Calculate area of Circle");
            System.out.println("5.Exit");
            try
            {
                System.out.println("Enter your choice:");
                int choice=Integer.parseInt(input.nextLine());
                switch(choice)
                {
                    case 1:
                        System.out.println("Enter width and height of triangle");
                        width=Double.parseDouble(input.nextLine());
                        height=Double.parseDouble(input.nextLine());
                        System.out.println(calculate.calculateAreaOfTriangle(width, height));
                        break;
                    case 2:
                        System.out.println("Enter width and height of rectangle");
                        width=Double.parseDouble(input.nextLine());
                        height=Double.parseDouble(input.nextLine());
                        System.out.println(calculate.calculateAreaOfRectangle(width, height));
                        break;    
                    case 3:
                        System.out.println("Enter width of square");
                        width=Double.parseDouble(input.nextLine());
                        System.out.println(calculate.calculateAreaOfSquare(width));
                        break;
                    case 4:
                        System.out.println("Enter radius of circle");
                        radius=Double.parseDouble(input.nextLine());
                        System.out.println(calculate.calculateAreaOfCircle(radius));
                        break;
                    case 5:
                        System.exit(1);
                        break;
                    default:
                        System.out.println("Enter valid choice");
                        break;
                }
            }
            catch(Exception e)
            {
                System.out.println("Invalid integer value");
            }
        }
    }
}
