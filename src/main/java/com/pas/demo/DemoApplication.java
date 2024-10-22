package com.pas.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoApplication {

	@RequestMapping("/login")
	public String loginMessage() {
		return "You are logged in!";
	}

	@RequestMapping("/")
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
