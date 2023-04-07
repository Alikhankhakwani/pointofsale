package com.example.pointofsale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.pointofsale.controller"})
@ComponentScan(basePackages = {"com.example.pointofsale.service"})
@ComponentScan(basePackages = {"com.example.pointofsale.repo"})
@ComponentScan(basePackages = {"com.example.pointofsale.Model"})
@ComponentScan(basePackages = {"com.example.pointofsale.config"})
public class PointofsaleApplication {

	public static void main(String[] args) {

		SpringApplication.run(PointofsaleApplication.class, args);
	}

}
