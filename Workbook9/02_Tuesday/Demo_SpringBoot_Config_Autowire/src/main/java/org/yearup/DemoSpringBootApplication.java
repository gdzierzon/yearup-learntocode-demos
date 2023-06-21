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
//@ComponentScan(basePackages = "org.yearup")
public class DemoSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringBootApplication.class, args);

	}

}
