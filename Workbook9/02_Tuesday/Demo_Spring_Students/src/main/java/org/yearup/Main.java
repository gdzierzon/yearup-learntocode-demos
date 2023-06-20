package org.yearup;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.yearup.data.RegistrationDao;
import org.yearup.models.Student;

public class Main
{
    public static void main(String[] args)
    {
        // Spring Application
        // Holds all the beans
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

        // this just lists all of the beans that are available
        var names = ctx.getBeanDefinitionNames();
        for(var name: names)
        {
            System.out.println(name);
        }

        Student waldo = ctx.getBean(Student.class);

        System.out.println(waldo.getFirstName());

        // get the class that implements the RegistrationDao interface
        // and has the @Component annotation
        RegistrationDao dao = ctx.getBean(RegistrationDao.class);

        dao.findById(1L);

        Long studentID = dao.persistStudent(
                new Student("Alan", "Turing", "Computer Science"));

        System.out.println("Student Registered with ID: "
                + studentID);

        Long studentID2 = dao.persistStudent(
                new Student("Johannes", "Kepler", "Astronomy"));

        System.out.println("Student Registered with ID: "
                + studentID2);

    }
}