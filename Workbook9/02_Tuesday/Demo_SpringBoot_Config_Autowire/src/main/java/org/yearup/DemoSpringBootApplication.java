package org.yearup;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.yearup.data.RegistrationDao;
import org.yearup.models.Student;

import javax.sql.DataSource;

@SpringBootApplication
@ComponentScan(basePackages = "org.yearup")
public class DemoSpringBootApplication {

	public static void main(String[] args) {
		// this line loads the Beans Container
//		SpringApplication.run(Application.class, args);
		SpringApplication.run(DemoSpringBootApplication.class, args);

//		for(var name: context.getBeanDefinitionNames())
//		{
//			System.out.println(name);
//		}

//		DataSource dataSource = context.getBean(DataSource.class);
//		System.out.println();

//		System.out.println();
//		RegistrationDao dao = context.getBean(RegistrationDao.class);
//		dao.register(null);
//
//		// String name = context.getBean("getFirstName").toString();
//		// String name = (String)context.getBean("getFirstName");
//		String name = context.getBean("defaultFirstName", String.class);
//
//		System.out.println(name);
//
//		System.out.println();
//		System.out.println("Student");
//		System.out.println("---------------------------");
//		Student student = context.getBean(Student.class);
//		System.out.println("First name: " + student.getFirstName());
//		System.out.println("Last name: " + student.getLastName());

	}

}
