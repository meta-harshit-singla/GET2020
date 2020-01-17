package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * HexCalc class is used to perform different operations on a hexadecimal number
 * @author Harshit
 *
 */
public class HexCalc implements GeneralisedCalculator
{
    final private static char[] check={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','a','b','c','d','e','f'};
    
    /**
     * Addition of two Hexadecimal numbers
     * @param firstHexaNumber denotes first Hexadecimal number
     * @param secondHexaNumber denotes second Hexadecimal number
     * @return Added Hexadecimal numbers in the form of a string
     */
    @Override
    public String addNumbers(String firstHexaNumber,String secondHexaNumber)
    {
        int firstDecimalNumber=Integer.parseInt(this.convertToDecimal(firstHexaNumber)),secondDecimalNumber=Integer.parseInt(this.convertToDecimal(secondHexaNumber));
        int addDecimalNumber=(firstDecimalNumber+secondDecimalNumber);
        return (convertToHexaDecimal(Integer.toString(addDecimalNumber)));
    }
    
    /**
     * Subtraction of two Hexadecimal numbers
     * @param firstHexaNumber denotes first Hexadecimal number
     * @param secondHexaNumber denotes second Hexadecimal number
     * @return Subtracted Hexadecimal numbers in the form of a string
     */
    @Override
    public String subtractNumbers(String firstHexaNumber,String secondHexaNumber)
    {
        int firstDecimalNumber=Integer.parseInt(this.convertToDecimal(firstHexaNumber)),secondDecimalNumber=Integer.parseInt(this.convertToDecimal(secondHexaNumber)),subtractDecimalNumber=(firstDecimalNumber-secondDecimalNumber);
        if(subtractDecimalNumber<0)
        {
           return ("-"+convertToHexaDecimal(Integer.toString(-1*subtractDecimalNumber)));
        }
        else if(subtractDecimalNumber>0)
        {
           return (convertToHexaDecimal(Integer.toString(subtractDecimalNumber)));
        }
        else
            return "0";
    }
    
    /**
     * Multiplication of two Hexadecimal numbers
     * @param firstHexaNumber denotes first Hexadecimal number
     * @param secondHexaNumber denotes second Hexadecimal number
     * @return Multiplied Hexadecimal numbers in the form of a string
     */
    @Override
    public String multiplyNumbers(String firstHexaNumber,String secondHexaNumber)
    {
        int firstDecimalNumber=Integer.parseInt(this.convertToDecimal(firstHexaNumber)),secondDecimalNumber=Integer.parseInt(this.convertToDecimal(secondHexaNumber)),multiplyDecimalNumber=(firstDecimalNumber*secondDecimalNumber);
        return (convertToHexaDecimal(Integer.toString(multiplyDecimalNumber)));
    }
    
    /**
     * Division of two Hexadecimal numbers
     * @param firstHexaNumber denotes first Hexadecimal number
     * @param secondHexaNumber denotes second Hexadecimal number
     * @return Divided Hexadecimal numbers in the form of a string
     */
    @Override
    public String divideNumbers(String firstHexaNumber,String secondHexaNumber)
    {
        int firstDecimalNumber=Integer.parseInt(this.convertToDecimal(firstHexaNumber)),secondDecimalNumber=Integer.parseInt(this.convertToDecimal(secondHexaNumber)),divideDecimalNumber=(firstDecimalNumber/secondDecimalNumber);
        return (convertToHexaDecimal(Integer.toString(divideDecimalNumber)));
    }
    
    /**
     * Checks Whether first Hexadecimal number is greater than second HexaDecimal number  
     * @param firstHexaNumber denotes first Hexadecimal number
     * @param secondHexaNumber denotes second Hexadecimal number
     * @return true if first hexadecimal number is greater than second hexadecimal number else false
     */
    boolean greaterThan(String firstHexaNumber, String secondHexaNumber) {
        if (firstHexaNumber.length() == secondHexaNumber.length()) 
        {
            if (firstHexaNumber.compareTo(secondHexaNumber) > 0) 
            {
                return true;
            } 
            else 
            {
                return false;
            }
        } 
        else if (firstHexaNumber.length() < secondHexaNumber.length()) 
        {
            if (firstHexaNumber.compareTo(secondHexaNumber) > 0) 
            {
                return true;
            } 
            else 
            {
                return false;
            }
        } 
        else 
        {
            if (firstHexaNumber.compareTo(secondHexaNumber) > 0) 
            {
                return true;
            } 
            else 
            {
                return false;
            }
        }
    }
    
    /**
     * Checks Whether first Hexadecimal number is smaller than second HexaDecimal number  
     * @param firstHexaNumber denotes first Hexadecimal number
     * @param secondHexaNumber denotes second Hexadecimal number
     * @return true if first hexadecimal number is smaller than second hexadecimal number else false
     */
    boolean lessThan(String firstHexaNumber, String secondHexaNumber) 
    {
        if (firstHexaNumber.length() == secondHexaNumber.length()) 
        {
            if (firstHexaNumber.compareTo(secondHexaNumber) < 0) 
            {
                return true;
            } 
            else 
            {
                return false;
            }
        } 
        else if (firstHexaNumber.length() < secondHexaNumber.length()) 
        {
            
            if (firstHexaNumber.compareTo(secondHexaNumber) < 0) 
            {
                return true;
            } 
            else 
            {
                return false;
            }
        } 
        else 
        {
            return false;
        }
    }
    
    /**
     * Checks Whether first Hexadecimal number is equal than second HexaDecimal number  
     * @param firstHexaNumber denotes first Hexadecimal number
     * @param secondHexaNumber denotes second Hexadecimal number
     * @return true if first hexadecimal number is equal than second hexadecimal number else false
     */
    boolean equals(String firstHexaNumber, String secondHexaNumber)
    {
        return firstHexaNumber.equalsIgnoreCase(secondHexaNumber);
    }

    /**
     * Checks whether number entered is a positive hexadecimal number or not
     * @param checkHexanumber denotes the hexadecimal number to be checked
     * @return true if the number is a positive hexadecimal number else returns false
     */
    boolean checkHexaDecimal(String checkHexanumber )
    {
        boolean flag=true;
        char hexanumber=checkHexanumber.charAt(1);
        int positivehexanumber=Integer.parseInt(String.valueOf(hexanumber));
        if(positivehexanumber>7)
        {
            flag=true;
                
        }
        else
            flag=false;  
        if(checkHexanumber.charAt(0)!='#' && checkHexanumber.charAt(0)!='$')
        {
            flag=true;        
        }
        for(int i=1;i<checkHexanumber.length();i++)
        {    
            for(int j=0;j<check.length;j++)
            {
                if(checkHexanumber.charAt(i)==check[j])
                {
                    flag=false;
                    break;
                }   
                else
                {
                    flag=true;
                }
            }
        }     
        return flag;
    }
    
    /**
     * Converts positive hexadecimal number to decimal number
     * @param hexaDecimalNumber denotes hexadecimal number which is to be converted
     * @return Decimal number in string form
     */
    String convertToDecimal(String hexaDecimalNumber)
    {
        int INTEGERCONSTANT=48,UPPERCASECONSTANT=55,LOWERCASECONSTANT=87,decimalNumber=0,hexaToInteger=0,j=0;
        char[] hexaDecimalNumberArr=hexaDecimalNumber.toCharArray();
        for(int i=(hexaDecimalNumberArr.length)-1;i>0;i--,j++)
        {
            if(Character.isDigit(hexaDecimalNumberArr[i]))
            {
                hexaToInteger=(int)hexaDecimalNumberArr[i]-INTEGERCONSTANT;
                decimalNumber+=hexaToInteger*Math.pow(16, j);
            }
            else if(Character.isUpperCase(hexaDecimalNumberArr[i]))
            {
                hexaToInteger=(int)hexaDecimalNumberArr[i]-UPPERCASECONSTANT;
                decimalNumber+=hexaToInteger*Math.pow(16, j);
            }
            else
            {
                hexaToInteger=(int)hexaDecimalNumberArr[i]-LOWERCASECONSTANT;
                decimalNumber+=hexaToInteger*Math.pow(16, j);
            }
        }
        String decimalNUmber=Integer.toString(decimalNumber);  
        return decimalNUmber;
    }
    
    /**
     * Converts decimal number to  positive hexadecimal number
     * @param decimalNumber denotes decimal number which is to be converted
     * @return HexaDecimal number in string form
     */
    String convertToHexaDecimal(String decimalNumber)
    {
        int HEX=16,remainder=0,j=0;
        List<Character> list=new ArrayList<Character>();
        int decimalNUmber=Integer.parseInt(decimalNumber);
        while(decimalNUmber!=0)
        {
            remainder=decimalNUmber%HEX;
            decimalNUmber=decimalNUmber/HEX;
            if(remainder>9)
            {
                list.add((char)(remainder+55));
            }
            else
            {
                list.add((char)(remainder+48));
            }
        }
        char[] charArray = new char[list.size()];

        for(int i = charArray.length-1; i >=0; i--,j++) {
            charArray[i] = list.get(j);
        }
        String output = new String(charArray);
        return output;
    }
     
    public static void main(String[] args) 
    {
        Scanner inp=new Scanner(System.in);
        String firstHexNumber,secondHexNumber;
        HexCalc obj1=new HexCalc(); 
        while(true)
        {
            int choice;
            System.out.println("Menu");
            System.out.println("1: ADD ");
            System.out.println("2: SUBTRACT ");
            System.out.println("3: MULTIPLY ");
            System.out.println("4: DIVIDE ");
            System.out.println("5: COMPARE ");
            System.out.println("6: HEXA DECIMAL TO DECIMAL ");
            System.out.println("7: DECIMAL TO HEXADECIMAL ");
            System.out.println("8: exit");
            System.out.println("\nEnter Your Choice: ");
            try
            {
                choice = Integer.parseInt(inp.nextLine());
                switch (choice)
                {
                    case 1:
                        System.out.println("Enter the positive Hexa-decimal number starting from # or $ sign: ");
                        firstHexNumber=inp.nextLine();
                        if(obj1.checkHexaDecimal(firstHexNumber))
                        {
                            System.out.println("INVALID");
                            continue;
                        }
                        System.out.println("Enter the positive Hexa-decimal number starting from # or $ sign: ");
                        secondHexNumber=inp.nextLine();
                        if(obj1.checkHexaDecimal(secondHexNumber))
                        {
                            System.out.println("INVALID");
                            continue;
                        }
                        System.out.println(obj1.addNumbers(firstHexNumber, secondHexNumber));
                        break;
                    case 2:
                        System.out.println("Enter the positive Hexa-decimal number starting from # or $ sign: ");
                        firstHexNumber=inp.nextLine();
                        if(obj1.checkHexaDecimal(firstHexNumber))
                        {
                            System.out.println("INVALID");
                            continue;
                        }
                        System.out.println("Enter the positive Hexa-decimal number starting from # or $ sign: ");
                        secondHexNumber=inp.nextLine();
                        if(obj1.checkHexaDecimal(secondHexNumber))
                        {
                            System.out.println("INVALID");
                            continue;
                        }
                        System.out.println(obj1.subtractNumbers(firstHexNumber, secondHexNumber));
                        break;
                    case 3:
                        System.out.println("Enter the positive Hexa-decimal number starting from # or $ sign: ");
                        firstHexNumber=inp.nextLine();
                        if(obj1.checkHexaDecimal(firstHexNumber))
                        {
                            System.out.println("INVALID");
                            continue;
                        }
                        System.out.println("Enter the positive Hexa-decimal number starting from # or $ sign: ");
                        secondHexNumber=inp.nextLine();
                        if(obj1.checkHexaDecimal(secondHexNumber))
                        {
                            System.out.println("INVALID");
                            continue;
                        }
                        System.out.println(obj1.multiplyNumbers(firstHexNumber, secondHexNumber));
                        break;    
                    case 4:
                        System.out.println("Enter the positive Hexa-decimal number starting from # or $ sign: ");
                        firstHexNumber=inp.nextLine();
                        if(obj1.checkHexaDecimal(firstHexNumber))
                        {
                            System.out.println("INVALID");
                            continue;
                        }
                        System.out.println("Enter the positive Hexa-decimal number starting from # or $ sign: ");
                        secondHexNumber=inp.nextLine();
                        if(obj1.checkHexaDecimal(secondHexNumber)||Integer.parseInt(obj1.convertToDecimal(secondHexNumber))==0)
                        {
                            System.out.println("INVALID");
                            continue;
                        }
                        System.out.println(obj1.divideNumbers(firstHexNumber, secondHexNumber));
                        break;   
                    case 5:
                        System.out.println("Enter the positive Hexa-decimal number starting from # or $ sign: ");
                        firstHexNumber=inp.nextLine();
                        if(obj1.checkHexaDecimal(firstHexNumber))
                        {
                            System.out.println("INVALID");
                            continue;
                        }
                        System.out.println("Enter the positive Hexa-decimal number starting from # or $ sign: ");
                        secondHexNumber=inp.nextLine();
                        if(obj1.checkHexaDecimal(secondHexNumber))
                        {
                            System.out.println("INVALID");
                            continue;
                        }
                        System.out.println("first number is greater than second: "+ obj1.greaterThan(firstHexNumber, secondHexNumber));
                        System.out.println("first number is smaller than second: "+ obj1.lessThan(firstHexNumber, secondHexNumber));
                        System.out.println("first number is equal to second: "+ firstHexNumber.equals(secondHexNumber));
                        break;   
                    case 6:
                        System.out.println("Enter the positive Hexa-decimal number starting from # or $ sign: ");
                        firstHexNumber=inp.nextLine();
                        if(obj1.checkHexaDecimal(firstHexNumber))
                        {
                            System.out.println("INVALID");
                            continue;
                        }
                        System.out.println(obj1.convertToDecimal(firstHexNumber));
                        break;  
                    case 7:
                        System.out.println("Enter decimal number:");
                        firstHexNumber=inp.nextLine();
                        obj1.convertToHexaDecimal(firstHexNumber);
                        System.out.println(obj1.convertToHexaDecimal(firstHexNumber));
                        break;   
                    case 8:
                        System.exit(1);
                        break;                    
                    default:
                        System.out.println("Invalid choice:");
                        break;   
                }
            }
            catch(Exception e)
            {
                System.out.println("enter valid choice");
            }
            inp.close();
        }        
    }   
}
