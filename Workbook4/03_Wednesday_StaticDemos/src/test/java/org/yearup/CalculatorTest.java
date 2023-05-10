package org.yearup;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest
{

    @Test
    public void add_should_AddTheNumbers()
    {
        // arrange
        double first = 12.5;
        double second = 12.5;
        double expected = 25;

        // act
        double actual = Calculator.add(first, second);

        // assert
        assertEquals(expected, actual, "because I added 12.5 + 12.5");
    }

}