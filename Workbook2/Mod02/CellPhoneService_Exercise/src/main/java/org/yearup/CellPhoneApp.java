package org.yearup;

public class CellPhoneApp
{
    public static void main(String[] args)
    {
        CellPhone phone1 = new CellPhone(1000000, "iPhone 14", "AT&T","800-555-5555","Dana Wyatt");
        CellPhone phone2 = new CellPhone(2168974, "iPhone 13", "Verizon","800-555-1212","Gregor Dzierzon");

        display(phone1);
        display(phone2);

        System.out.println();
        phone1.dial(phone2.getPhoneNumber());
        phone2.dial(phone1);

    }

    public static void display(CellPhone phone)
    {
        System.out.println();
        System.out.println(phone.getOwner() + "'s phone");
        System.out.println(phone.getPhoneNumber());
        System.out.println(phone.getModel());
        System.out.println("Carrier: " + phone.getCarrier());
        System.out.println("Serial Number: " + phone.getSerialNumber());
    }
}