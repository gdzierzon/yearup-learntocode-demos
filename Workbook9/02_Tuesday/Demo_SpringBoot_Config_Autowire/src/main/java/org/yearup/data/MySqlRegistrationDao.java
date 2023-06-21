package org.yearup.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.yearup.models.Student;

import javax.sql.DataSource;

@Component
public class MySqlRegistrationDao implements  RegistrationDao
{
    private DataSource dataSource;

    // constructor injection
    @Autowired
    public MySqlRegistrationDao(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    @Override
    public Student register(Student student)
    {
        System.out.println("testing registration DAO");
        return null;
    }
}
