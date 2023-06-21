package org.yearup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.yearup.models.Student;

import javax.sql.DataSource;

@Component
public class Application implements CommandLineRunner
{
    @Autowired
    @Qualifier("defaultLastName")
    private String name;

    private DataSource dataSource;

//    public Application()
//    {
//        System.out.println();
//        System.out.println("Application");
//        System.out.println();
//    }
    @Autowired
    public Application(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    @Override
    public void run(String... args) throws Exception
    {
        System.out.println("running application");
        System.out.println();
        System.out.println("Data Source");
        System.out.println("---------------------------");
        System.out.println(name);
//        System.out.println(dataSource.getConnection());
    }
}
