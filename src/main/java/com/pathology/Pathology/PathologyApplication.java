package com.pathology.Pathology;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.pathology.Pathology")
public class PathologyApplication {

	public static void main(String[] args) {
		SpringApplication.run(PathologyApplication.class, args);
	}

}
