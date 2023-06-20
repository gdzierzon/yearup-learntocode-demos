package org.yearup.data;

import org.springframework.stereotype.Component;
import org.yearup.models.Student;

@Component
public class MySqlRegistrationDao implements  RegistrationDao
{
    @Override
    public Student register(Student student)
    {
        System.out.println("testing registration DAO");
        return null;
    }
}
