package org.yearup;

public class Main
{
    public static void main(String[] args)
    {
//        Person gregor = new Person("Gregory", "Dzierzon");
//        // use the setter to change the firstName
//        gregor.setFirstName("Gregor");
//        System.out.println(gregor.getFullName());

        Car car = new Car("Ford", "Mustang");
        System.out.println("Speed: " + car.getSpeed());
        car.accelerate(10);
        System.out.println("Speed: " + car.getSpeed());
        car.accelerate(35);
        System.out.println("Speed: " + car.getSpeed());
        car.brake(20);
        System.out.println("Speed: " + car.getSpeed());
        car.brake(100);
        System.out.println("Speed: " + car.getSpeed());
    }
}