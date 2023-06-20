package org.yearup.data;

import org.yearup.models.Student;

public interface RegistrationDao
{
    public Long persistStudent(Student student);
    public Student findById(Long id);
}
