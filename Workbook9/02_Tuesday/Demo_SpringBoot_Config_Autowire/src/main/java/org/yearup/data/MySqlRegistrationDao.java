package org.yearup.data;

import org.springframework.stereotype.Component;
import org.yearup.models.Student;

@Component
public class MySqlRegistrationDao implements  RegistrationDao
{
    public MySqlRegistrationDao()
    {
        System.out.println();
        System.out.println("Registration DAO");
        System.out.println();
    }

    @Override
    public Student register(Student student)
    {
        System.out.println("testing registration DAO");
        return null;
    }
}
