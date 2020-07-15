package com.bolsadeideas.springboot.omboarding.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.bolsadeideas.springboot.onboarding")
public class SpringBootOnboardingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootOnboardingApplication.class, args);
	}

}
