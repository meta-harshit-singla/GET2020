package com.metacube;

import java.util.Stack;

public class stackImpl
{
    public int infixevalution(String expression)
    {
        if (expression == "")
        {
            return -1;
        }
        // stack for number
        Stack<Integer> number = new Stack<>();
        
        // stack for operation
        Stack<Character> operation = new Stack<>();
        
        // storing the element in respective stack
        for (int index = 0; index < expression.length(); index++)
        {
            
            // store each character
            char eachchar = expression.charAt(index);
            
            // check that no is integer or not
            
            if (Character.isDigit(eachchar))
            {
                int num = 0;
                // if the no is greater than one digit
                while (Character.isDigit(eachchar))
                {
                    num = num * 10 + (eachchar - '0');
                    index++;
                    if (index < expression.length())
                    {
                        eachchar = expression.charAt(index);
                    }
                    else
                    {
                        break;
                    }
                }
                index--;
                // push the no into stack
                number.push(num);
            }
            
            // check the character is '('
            
            else if (eachchar == '(')
            {
                operation.push(eachchar);
                
            }
            else if (eachchar == ')')
            {
                while (operation.peek() != '(')
                {
                    
                    int output = preformOperation(number, operation);
                    // push it back to stack
                    
                    number.push(output);
                }
                
                operation.pop();
            }
            else if (isOperator(eachchar))
            {
                while (!operation.isEmpty()
                        && precedence(eachchar) < precedence(operation.peek()))
                {
                    
                    int output = preformOperation(number, operation);
                    // push it back to stack
                    number.push(output);
                }
                
                operation.push(eachchar);
            }
        }
        while (!operation.isEmpty())
        {
            int output = preformOperation(number, operation);
            // push it back to stack
            number.push(output);
        }
        
        return number.pop();
    }
    
    /**
     * This function defines the priority
     * 
     * @param peek
     * @return
     */
    private int precedence(Character peek)
    {
        
        int result;
        if (peek == '+' || peek == '-')
        {
            result = 1;
        }
        else if ((peek == '*' || peek == '/'))
        {
            result = 2;
        }
        else if ((peek == '^'))
        {
            result = 3;
        }
        else
        {
            result = -1;
        }
        
        return result;
    }
    
    /**
     * This check whether given char is operator or not
     * 
     * @param eachchar
     * @return
     */
    private boolean isOperator(char eachchar)
    {
        boolean result = false;
        if (eachchar == '+' || eachchar == '-' || eachchar == '*'
                || eachchar == '/' || eachchar == '^')
        {
            result = true;
        }
        return result;
        
    }
    
    private int preformOperation(Stack<Integer> number,
            Stack<Character> operation)
    {
        int result = 0;
        int first = number.pop();
        int second = number.pop();
        char operator = operation.pop();
        if (operator == '+')
        {
            result = first + second;
        }
        else if (operator == '-')
        {
            result = second - first;
        }
        else if (operator == '*')
        {
            result = first * second;
        }
        else if (operator == '/')
        {
            if (first == 0)
            {
                throw new UnsupportedOperationException(
                        "operation can not be supported");
            }
            result = second / first;
        }
        else if (operator == '^')
        {
            result = (int) Math.pow(second, first);
            
        }
        
        return result;
        
    }
}