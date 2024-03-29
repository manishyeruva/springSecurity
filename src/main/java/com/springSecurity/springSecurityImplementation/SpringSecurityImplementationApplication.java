package com.springSecurity.springSecurityImplementation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.web.access.intercept.AuthorizationFilter;

@SpringBootApplication
public class SpringSecurityImplementationApplication {

	public static void main(String[]  args) {
		SpringApplication.run(SpringSecurityImplementationApplication.class, args);
	}

}
