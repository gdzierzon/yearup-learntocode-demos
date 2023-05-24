package org.yearup;

public class StringPair
{
    // A pair contains two integers
    private String leftString;
    private String rightString;

    public StringPair(String leftString, String rightString) {
        this.leftString = leftString;
        this.rightString = rightString;
    }

    public String getLeftString()  {
        return this.leftString;
    }

    public String getRightString()  {
        return this.rightString;
    }

    public void swap() {
        String temp = leftString;
        leftString = rightString;
        rightString = temp;
    }

    @Override
    public String toString()
    {
        return  leftString + " : " + rightString;
    }
}
