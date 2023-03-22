package com.sist.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan(basePackages = {"com.sist.web.controller","com.sist.web.entity","com.sist.web.dao","com.sist.web.rest"})

@SpringBootApplication
public class Kmw3ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(Kmw3ProjectApplication.class, args);
	}

}
