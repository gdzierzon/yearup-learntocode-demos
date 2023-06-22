package org.yearup.world;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WorldDemoApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(WorldDemoApplication.class, args);
//
//		for(var name : context.getBeanDefinitionNames())
//		{
//			System.out.println(name);
//		}
	}

}
