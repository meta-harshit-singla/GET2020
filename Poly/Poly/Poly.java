package main;
public class Poly 
{
    private final int coefficient[];
    /**
     * Parameterized Constructor used to initialize coefficient variable 
     * @param inputCoefficient denotes the coefficients entered by the user 
     */
    public Poly(int inputCoefficient[])
    {
        this.coefficient=inputCoefficient;
        if(validatePoly())
            throw new AssertionError("Coefficient cannot be zero");
    }
    /**
     * This method is used to check whether the coefficient entered by the user is zero or not
     * @return true if coefficient is zero else return false
     */
    private boolean validatePoly()
    {
        boolean flag=true;
        for(int i=0;i<coefficient.length;i++)
        {
            if(coefficient[i]==0)
            {
                flag=true;
                break;
            }
            else 
                flag=false;
        }
        return flag;
    }
    public int degree()
    {
        return coefficient.length-1;
    }
    /**
     * Evaluation of the polynomial expression
     * @param value the value of the variable
     * @return the result of the evaluated polynomial
     */
    public float evaluate(float value)
    {
        float answer=0.0f;
        int degreeOfPolynomial=degree();
        for(int i=0;i<coefficient.length;i++)
        {
            answer+=coefficient[i]*Math.pow(value,degreeOfPolynomial);
            degreeOfPolynomial--;
        }
        return answer;
    }
    /**
     * Adding two polynomials
     * @param p1 The first polynomial
     * @param p2 the second polynomial to be multiplied
     * @return new reference to the added polynomial
     */
    public int[] addPoly(Poly p1,Poly p2)
    {
        int poly1Coeffecient[] = p1.coefficient;
        int poly2Coeffecient[] = p2.coefficient;
        int largePoly[] = poly1Coeffecient.length > poly2Coeffecient.length ? poly1Coeffecient: poly2Coeffecient;
        int smallPoly[] = poly1Coeffecient.length < poly2Coeffecient.length ? poly1Coeffecient: poly2Coeffecient;
        int distinct=largePoly.length-smallPoly.length;
        int addPoly[]=new int[largePoly.length];
        int index=0;
        for(index=0;index<distinct;index++)
        {
            addPoly[index]=largePoly[index];
        }
        while(index<largePoly.length)
        {
            addPoly[index]=smallPoly[index-distinct]+largePoly[index];
            index++;
        }
        return addPoly;
    }
    /**
     * Multiplying two polynomials
     * @param p1 The first polynomial
     * @param p2 the second polynomial to be multiplied
     * @return new reference to the multiplied polynomial
     */
    public int[] multilpyPoly(Poly p1,Poly p2)
    {
        int multipliedPoly[] = new int[p1.degree() + p2.degree() + 1];
        int poly1Coefficient[] = p1.coefficient;
        int poly2Coefficient[] = p2.coefficient;
        int largePoly[] = poly1Coefficient.length > poly2Coefficient.length ? poly1Coefficient: poly2Coefficient;
        int smallPoly[] = poly1Coefficient.length < poly2Coefficient.length ? poly1Coefficient: poly2Coefficient;
        for (int smallPolyIndex = smallPoly.length - 1; smallPolyIndex >= 0; smallPolyIndex--) {
            for (int largePolyIndex = largePoly.length - 1; largePolyIndex >= 0; largePolyIndex--) {
                multipliedPoly[smallPolyIndex + largePolyIndex] = multipliedPoly[smallPolyIndex+largePolyIndex]+smallPoly[smallPoly.length - smallPolyIndex - 1]* largePoly[largePoly.length - largePolyIndex - 1];
            }
        }
        // reversing the array
        int tempArray[] = new int[multipliedPoly.length];
        for (int i = 1; i <= multipliedPoly.length; i++) {
            tempArray[i - 1] = multipliedPoly[multipliedPoly.length - i];
        }
        multipliedPoly = tempArray;
        return multipliedPoly;
    }
    void print()
    {
        for(int i=0,j=degree();i<this.coefficient.length;i++,j--)
        {
            System.out.println(coefficient[i]+"x "+j);
        }
    }
}
