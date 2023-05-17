package org.yearup;

public class Main
{
    public static void main(String[] args)
    {
        Person p = new Person("Aiden Patel");
        p.play();
        Child c = new Child("Isabella Santos");
        c.play();
        SoftballPlayer sb = new SoftballPlayer("Liam Wang");
        sb.play();
        Violinist v = new Violinist("Mia Alves");
        v.play();
    }
}