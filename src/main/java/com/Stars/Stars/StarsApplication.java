package com.Stars.Stars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class StarsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarsApplication.class, args);
	}

}
