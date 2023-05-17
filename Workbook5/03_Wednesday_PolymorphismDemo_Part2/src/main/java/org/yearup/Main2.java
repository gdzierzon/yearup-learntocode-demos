package org.yearup;

import java.util.ArrayList;

public class Main2
{
    public static void main(String[] args)
    {
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Child("Noah Kim"));
        people.add(new Child("Sophia Garcia"));
        people.add(new Child("Lucas Nguyen"));
        people.add(new Child("Ava Khan"));
        people.add(new Child("Oliver Kowalski"));
        people.add(new Child("Emma Li"));
        people.add(new SoftballPlayer("Olivia Silva"));
        people.add(new SoftballPlayer("Ethan Nakamura"));
        people.add(new SoftballPlayer("Jackson Chen"));
        people.add(new SoftballPlayer("Emma Fernandez"));
        people.add(new SoftballPlayer("Aiden Das"));
        people.add(new SoftballPlayer("Sophia Costa"));
        people.add(new SoftballPlayer("Lucas O'Reilly"));
        people.add(new SoftballPlayer("Mia Santos"));
        people.add(new SoftballPlayer("Liam Singh"));
        people.add(new SoftballPlayer("Isabella Dubois"));
        people.add(new Violinist("Noah Kimura"));
        people.add(new Violinist("Ava Nascimento"));
        people.add(new Violinist("Logan Park"));
        people.add(new Violinist("Harper Li"));
        people.add(new Violinist("Oliver Wang"));
        people.add(new Violinist("Charlotte Martinez"));
        people.add(new Violinist("Caleb Ibrahim"));
        people.add(new Violinist("Amelia Rodriguez"));
        people.add(new Violinist("Benjamin Nguyen"));
        people.add(new Violinist("Abigail Adachi"));


        for(Person person : people)
        {
            if(person instanceof SoftballPlayer)
            {
                SoftballPlayer player = (SoftballPlayer) person;
                player.stretch();
            }
            person.play();
        }

    }
}