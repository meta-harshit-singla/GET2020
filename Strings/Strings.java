package main;
import java.util.Scanner;
public class Strings 
{
    /**
     * stringLength method is used to calculate the length of a string 
     * @param givenString denotes the string in the form of a character array to which the length is to be calculated
     * @return the length of the string
     */
    int stringLength(char[] givenString)
    {
        int length=0;
        for(char c  :givenString)
        {
            length++;
        }
        return length;
    }
    /**
     * Used to compare two strings
     * @param firstString denotes the first string in the form of a character array which is to be compared
     * @param secondString denotes the second string in the form of a character array which is to be compared
     * @return 1 if the two strings are equal else returns 0
     */
    int stringCompare(char[] firstString,char[] secondString)
    {
        int flag=0;
        if(stringLength(firstString)==stringLength(secondString))
        {
            for(int i=0;i<stringLength(firstString);i++)
            {
                if(firstString[i]==secondString[i])
                    flag=1;
                else
                {
                    flag=0;
                    break;
                }
            }
        }
        else
            flag= 0;
        return flag;
    }
    /**
     * reverseString method is used to reverse the entered string
     * @param firstString denotes the first string in the form of a character array which is to be reversed
     * @return the reversed string
     */
    char[] reverseString(char[] firstString)
    {
        int lengthOfString=stringLength(firstString),j=lengthOfString-1;
        char[] reversesString=new char[lengthOfString];
        for(int i=0;i<lengthOfString;i++,j--)
        {
            reversesString[i]=firstString[j];
        }
        return reversesString;
    }
    /**
     * Converts the characters in a string to opposite case(Uppercase alphabets to lowercase alphabets and vice versa)
     * @param firstString denotes the first string in the form of a character array which is to be converted to opposite case
     * @return the converted string
     */
    char[] convertsCharactersToOppositeCaseInString(char[] firstString)
    {
        int lengthOfString=stringLength(firstString);
        char[] newReplacedString=new char[lengthOfString];
        for(int i=0;i<lengthOfString;i++)
        {
            if(firstString[i]>=65 && firstString[i]<=90)
                newReplacedString[i]=(char)(firstString[i]+32);
            else if(firstString[i]>=97 && firstString[i]<=122)
                newReplacedString[i]=(char)(firstString[i]-32);
            else
                newReplacedString[i]=(char)firstString[i];
        }
        return newReplacedString;
    }
    /**
     * Finds the largest word among a string
     * @param firstString denotes the string in the form of a character array from which the largest word is to be derived
     * @return the largest word of a string and If two words are of same length then return last word.
     */
    char[] largestWord(char[] firstString)
    {
        int lengthOfWord=0,lengthOfMaximumWord=0,index=0,i=0,j=0;
        for(i=0,j=0;j<stringLength(firstString);i++,j++)
        {
            if(firstString[i]==' ')
            {
                if(lengthOfMaximumWord<=lengthOfWord)
                {
                    lengthOfMaximumWord=lengthOfWord;
                    index=i;
                }
                lengthOfWord=0;
            }       
            else if(j==stringLength(firstString)-1)
            {
                if(lengthOfMaximumWord<=lengthOfWord)
                {
                    lengthOfMaximumWord=lengthOfWord;
                    index=j;
                }
            }       
            else   
                lengthOfWord++;
        }
        char[] largeWord=new char[lengthOfMaximumWord+1];
        j=0;
        for(i=index-lengthOfMaximumWord;i<=index;i++,j++)
            largeWord[j]=firstString[i];
        return largeWord;
    }
    /**
     * Displays the array of characters
     * @param firstString denotes the character array which is to be displayed 
     */
    void display(char[] firstString)
    {
        for(int i=0;i<stringLength(firstString);i++)
        {
            System.out.print(firstString[i]);
        }
    }
    public static void main(String[] args) 
    {
        Scanner input=new Scanner(System.in);
        Strings stringsInstance=new Strings();
        while(true)
        {
            System.out.println("\nMENU");
            System.out.println("1.Compare Strings");
            System.out.println("2.Reverse a String");
            System.out.println("3.Conversion of Alphabets to opposite case:");
            System.out.println("4.Largest Word");
            System.out.println("5.Exit");
            try
            {
                int choice=Integer.parseInt(input.nextLine());
                switch(choice)
                {
                    case 1:
                        System.out.println("Enter the string:");
                        String inputString1=input.nextLine();
                        System.out.println("Enter the string:");
                        String inputString2=input.nextLine();
                        if(stringsInstance.stringCompare(inputString1.toCharArray(),inputString2.toCharArray())==0)
                        {
                            System.out.println(inputString1+" is not equal to "+inputString2);
                        }
                        else
                            System.out.println(inputString1+" is equal to "+inputString2);
                        break;
                    case 2:
                    {
                        System.out.println("Enter the string:");
                        String inputString=input.nextLine();
                        char[] charArray=inputString.toCharArray();
                        System.out.print("Reverse of a string: ");
                        stringsInstance.display(stringsInstance.reverseString(charArray));
                        break;
                    }
                    case 3:
                    {
                        System.out.println("Enter the string:");
                        String inputString=input.nextLine();
                        char[] charArray=inputString.toCharArray();
                        System.out.print("Converted string: ");
                        stringsInstance.display(stringsInstance.convertsCharactersToOppositeCaseInString(charArray));
                        break;
                    }
                    case 4:
                    {
                        System.out.println("Enter the string:");
                        String inputString=input.nextLine();
                        char[] charArray=inputString.toCharArray();
                        System.out.print("Largest Word: ");
                        stringsInstance.display(stringsInstance.largestWord(charArray));
                        break;
                    }                  
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            }
            catch(Exception e)
            {
                System.out.println("Enter valid integer");
            }
        }
    }
}
