package com.demo.redisapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class RedisappApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisappApplication.class, args);
	}

}
