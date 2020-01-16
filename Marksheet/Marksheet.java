package main;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Marksheet 
{
    private Map<Integer,Float> grades=new HashMap<Integer,Float>();
    /**
     * Takes positive grades input from the user
     * @return the total number of students
     */
    int input()
    {
        int numberOfStudents=0;
        boolean flag=true;
        Scanner input=new Scanner(System.in);
        int firstStudent=0;
        while(flag)
        {
            try
            {
                System.out.println("Enter the number of students:");
                flag=false;
                numberOfStudents=Integer.parseInt(input.nextLine());
            }
            catch(ArithmeticException e)
            {
                flag=true;
                System.out.println("Invalid integer");
            }
            catch(Exception e)
            {
                flag=true;
                System.out.println("Enter valid Integer value");      
            }
        }
        while(firstStudent<numberOfStudents)
        {
            try
            {
                System.out.println("Enter the grade for "+(firstStudent+1)+" student:");
                Float grade=Float.parseFloat(input.nextLine());
                grades.put(firstStudent,grade);
                firstStudent++;
            }
            catch(ArithmeticException e)
            {
                System.out.println("Enter correct grade");
            }
            catch(Exception e)
            {
                System.out.println("Enter correct grade");
            }
        }
        return numberOfStudents;       
    }
    /**
     * Calculates the average of the grades of students
     * @param numberOfStudents denotes total number of students
     * @return average of the grades of students
     */
    float calculateAverage(int numberOfStudents)
    {
        float total=0.0f;
        Iterator<Float> iterate=grades.values().iterator();
        while(iterate.hasNext())
        {
            total+=iterate.next();
        }
        return (total/numberOfStudents);
    }
    /**
     * Finds the maximum grade among all the grades of students
     * @return the maximum grade among all the grades of students
     */
    float maximumGrade()
    {
        return Collections.max(grades.values());
    }
    /**
     * Finds the minimum grade among all the grades of students
     * @return the minimum grade among all the grades of students
     */
    float minimumGrade()
    {
        return Collections.min(grades.values());
    }
    /**
     * Calculates the pass percentage of all the students(grades>=40 are treated as pass)
     * @return the pass percentage of all the students
     */
    float calculatePassPercentage()
    {
        Iterator<Float> iterate=grades.values().iterator();
        int passStudent=0;
        while(iterate.hasNext())
        {
            if(iterate.next()>=40)
            {
                passStudent++;
            }
        }
        return (((float)passStudent/grades.size())*100);
    }
    public static void main(String[] args) 
    {
        Scanner s=new Scanner(System.in);
        int n=0;
        Marksheet marksheetInstance=new Marksheet();
        while(true)
        {
            System.out.println("\nMENU");
            System.out.println("1.Input");
            System.out.println("2.Average");
            System.out.println("3.Maximum");
            System.out.println("4.Minimum");
            System.out.println("5.Percentage");
            System.out.println("6.Exit");
            try
            { 
                System.out.println("\nEnter your choice:");
                int choice =Integer.parseInt(s.nextLine());
                switch(choice)
                {
                    case 1:
                        n=marksheetInstance.input();
                        break;
                    case 2:
                        System.out.printf("%.2f",marksheetInstance.calculateAverage(n));
                        break;
                    case 3:
                        System.out.printf("%.2f",marksheetInstance.maximumGrade());
                        break;
                    case 4:
                        System.out.printf("%.2f",marksheetInstance.minimumGrade());
                        break;
                    case 5:
                        System.out.printf("%.2f",marksheetInstance.calculatePassPercentage());
                        System.out.print("%");
                        break;
                    case 6:
                        System.exit(1);
                        break;
                    default:
                        System.out.println("Invalid Choice");
                        break;
                }
            }
            catch(ArithmeticException e)
            {
                System.out.println("Invalid");
            }
            catch(Exception e)
            {
                System.out.println("Invalid");
            }
        }
    }
}