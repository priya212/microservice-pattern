package com.stackroute.muzixservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@EnableCaching
@SpringBootApplication
public class MuzixServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(MuzixServiceApplication.class, args);



	}

}
