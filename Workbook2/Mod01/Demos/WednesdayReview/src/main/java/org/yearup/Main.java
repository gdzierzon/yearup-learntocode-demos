package org.yearup;

public class Main
{
    public static void main(String[] args)
    {
        // CALL A FUNCTION
        int quarter = quarterOf2(5);
        displayValue(quarter);
    }

    // DEFINING A FUNCTION
    // signature
    // int -> what datatype will be returned
    // quarterOf -> the name of the function
    // int month -> input parameter
    public static int quarterOf(int month)
    // body
    {
        if(month >= 1 && month <= 3)
        {
            return 1;
        }
        else if(month >= 4 && month <= 6)
        {
            return 2;
        }
        else if(month >= 7 && month <= 9)
        {
            return 3;
        }
        else
        {
            return 4;
        }
    }

    public static int quarterOf2(int month)
    {
        /*
        Jan, Feb, Mar - return 1
        Apr, May, Jun - return 2
        Jul, Aug, Sep - return 3
        Oct, Nov, Dec - return 4
         */
        int quarter;

        // which quarter of the year is the month in
        switch (month)
        {
            case 1:
            case 2:
            case 3:
                quarter = 1;
                break;
            case 4:
            case 5:
            case 6:
                quarter = 2;
                break;
            case 7:
            case 8:
            case 9:
                quarter = 3;
                break;
            default:
                quarter = 4;
                break;
        }

        return quarter;

    }

    public static void displayValue(int value)
    {
        System.out.println(value);
    }
}
