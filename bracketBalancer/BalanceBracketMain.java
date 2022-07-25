package com.greatlearning.dsa.lab3.bracketBalancer;

public class BalanceBracketMain
{
    public static void main(String[] args)
    {
        String bracketExpression = "([{}])";
        boolean result = BalanceBracketChecker.isBalance(bracketExpression);

        if(result)
            System.out.println("The entered String has Balanced Brackets");
        else
            System.out.println("The entered String do not contain Balanced Brackets");
    }
}
