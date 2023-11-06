package com.go2climb.go2climbsecurityservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Go2climbSecurityServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Go2climbSecurityServiceApplication.class, args);
	}

}
