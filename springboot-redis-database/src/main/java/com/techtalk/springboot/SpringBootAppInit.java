package com.techtalk.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootAppInit {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAppInit.class, args);
	}
}
