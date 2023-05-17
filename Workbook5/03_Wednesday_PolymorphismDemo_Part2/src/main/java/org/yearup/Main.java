package org.yearup;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        Person p = new Person("Aiden Patel");
        Child c = new Child("Isabella Santos");
        SoftballPlayer sb = new SoftballPlayer("Liam Wang");
        Violinist v = new Violinist("Mia Alves");

        ArrayList<Child> children = new ArrayList<>();
        children.add(new Child("Noah Kim"));
        children.add(new Child("Sophia Garcia"));
        children.add(new Child("Lucas Nguyen"));
        children.add(new Child("Ava Khan"));
        children.add(new Child("Oliver Kowalski"));
        children.add(new Child("Emma Li"));

        ArrayList<SoftballPlayer> players = new ArrayList<>();
        players.add(new SoftballPlayer("Olivia Silva"));
        players.add(new SoftballPlayer("Ethan Nakamura"));
        players.add(new SoftballPlayer("Jackson Chen"));
        players.add(new SoftballPlayer("Emma Fernandez"));
        players.add(new SoftballPlayer("Aiden Das"));
        players.add(new SoftballPlayer("Sophia Costa"));
        players.add(new SoftballPlayer("Lucas O'Reilly"));
        players.add(new SoftballPlayer("Mia Santos"));
        players.add(new SoftballPlayer("Liam Singh"));
        players.add(new SoftballPlayer("Isabella Dubois"));

        ArrayList<Violinist> musicians = new ArrayList<>();
        musicians.add(new Violinist("Noah Kimura"));
        musicians.add(new Violinist("Ava Nascimento"));
        musicians.add(new Violinist("Logan Park"));
        musicians.add(new Violinist("Harper Li"));
        musicians.add(new Violinist("Oliver Wang"));
        musicians.add(new Violinist("Charlotte Martinez"));
        musicians.add(new Violinist("Caleb Ibrahim"));
        musicians.add(new Violinist("Amelia Rodriguez"));
        musicians.add(new Violinist("Benjamin Nguyen"));
        musicians.add(new Violinist("Abigail Adachi"));


        for(Child child : children)
        {
            child.play();
        }

        for(SoftballPlayer player : players)
        {
            player.play();
        }

        for(Violinist musican : musicians)
        {
            musican.play();
        }
    }
}