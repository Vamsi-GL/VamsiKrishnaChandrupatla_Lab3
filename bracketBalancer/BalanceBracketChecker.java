package com.greatlearning.dsa.lab3.bracketBalancer;

import java.util.Stack;

public class BalanceBracketChecker
{
    static boolean isBalance(String bracketExpression)
    {
       Stack<Character> stack = new Stack<>();//Create stack to store given brackets string

        //Traversing the Expression
        for(int i=0;i<bracketExpression.length();i++)
        {
            char bracket = bracketExpression.charAt(i);
            if(bracket == '(' || bracket == '[' || bracket == '{')
            {
                //Push the element into stack
                stack.push(bracket);
                continue;
            }
            //if current character is not opening bracket, then it must be closing. So stack cannot be empty at this point.
            if(stack.isEmpty())
            {
                return false;
            }

            char check;
            switch(bracket){
                case ')':
                    check = stack.pop();
                    if(check == '{' || check == '[')
                    {
                        return false;
                    }
                    break;

                case ']':
                    check = stack.pop();
                    if(check == '{' || check == '(')
                    {
                        return false;
                    }
                    break;

                case '}':
                    check = stack.pop();
                    if(check == '[' || check == '(')
                    {
                        return false;
                    }
                    break;
            }
        }
        return (stack.isEmpty());
    }
}
