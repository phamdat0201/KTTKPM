package com.datpt.RedisWithJava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.datpt.RedisWithJava")
public class RedisWithJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisWithJavaApplication.class, args);
	}
}