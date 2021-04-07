package com.example.ratemanagment;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RatemanagmentApplication {

	public static void main(String[] args) {
		PropertyConfigurator.configure("src/log4j.properties");
		SpringApplication.run(RatemanagmentApplication.class, args);
	}

}
