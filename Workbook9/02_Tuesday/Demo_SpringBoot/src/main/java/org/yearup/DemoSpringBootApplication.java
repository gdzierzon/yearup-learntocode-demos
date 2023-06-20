package org.yearup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.yearup.data.RegistrationDao;

@SpringBootApplication
public class DemoSpringBootApplication {

	public static void main(String[] args) {
		// this line loads the Beans Container
		ApplicationContext context = SpringApplication.run(DemoSpringBootApplication.class, args);

		for(var name: context.getBeanDefinitionNames())
		{
			System.out.println(name);
		}

		System.out.println();
		RegistrationDao dao = context.getBean(RegistrationDao.class);
		dao.register(null);
	}

}
