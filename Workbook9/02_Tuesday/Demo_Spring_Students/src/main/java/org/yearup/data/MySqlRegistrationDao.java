package org.yearup.data;

import org.yearup.models.Student;

//@Component
public class MySqlRegistrationDao implements RegistrationDao
{
    @Override
    public Long persistStudent(Student student)
    {
        System.out.println("Registering student in the MySQLRegistration Service");
        return null;
    }

    @Override
    public Student findById(Long id)
    {
        System.out.println("Finding student by ID in the MySQLRegistration Service");
        return null;
    }
}
