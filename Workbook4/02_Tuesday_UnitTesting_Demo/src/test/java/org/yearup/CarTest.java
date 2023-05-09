package org.yearup;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest
{
    @Test
    public void functionName_should_describeTestScenario()
    {
        // arrange

        // act

        // assert
    }

    @Test
    public void accelerate_should_increaseCarSpeedExactly_whenInitialSpeedIs0()
    {
        // arrange - this is the setup for the test
        // constants the things that DON'T change
        Car car = new Car("Ford", "Mustang");
        int changeInSpeed = 10;
        int expectedSpeed = 10;

        // act - the ONE function we are testing on the object
        // the variable - this is the ONE THING that I am changing
        car.accelerate(changeInSpeed);
        int actualSpeed = car.getSpeed();

        // assert
        // this is where we verify that things worked or did not work
        assertEquals(expectedSpeed, actualSpeed,"because I accelerated to 10 from 0");

    }

    @Test
    public void brake_should_decreaseSpeedToZero_whenInputSpeedIsGreaterThanCurrentSpeed()
    {
        // arrange
        Car car = new Car("Ford", "Mustang");
        int startSpeed = 25;
        int brakeSpeed = 100;
        int expectedSpeed = 0;
        // set the current speed
        car.accelerate(startSpeed);

        // act
        car.brake(brakeSpeed);

        // assert
        int actualSpeed = car.getSpeed();
        assertEquals(expectedSpeed, actualSpeed, "Because the speed should never fall below zero: \nstart speed was 25\nbrake speed was 100");

    }

}