package com.example.sessprac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SesspracApplication {

	public static void main(String[] args) {
		SpringApplication.run(SesspracApplication.class, args);
	}

}
