package com.metacube;

public class AreaOfTriangle
{
    public double calculateArea(double side1,double side2,double side3)
    {
        double halfOfTriangle=(side1+side2+side3)/2;
        return (Math.sqrt(halfOfTriangle*(halfOfTriangle-side1)*(halfOfTriangle-side2)*(halfOfTriangle-side3)));
    }
}
