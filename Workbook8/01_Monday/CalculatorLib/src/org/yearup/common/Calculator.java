package org.yearup.common;

public class Calculator
{
    private double answer = 0;

    public double getAnswer()
    {
        return answer;
    }

    public double clear()
    {
        answer = 0;
        return answer;
    }

    public double add(double value)
    {
        answer += value;
        return answer;
    }

    public double subtract(double value)
    {
        answer -= value;
        return answer;
    }

    public double multiply(double value)
    {
        answer *= value;
        return answer;
    }

    public double divide(double value)
    {
        answer /= value;
        return answer;
    }
}
