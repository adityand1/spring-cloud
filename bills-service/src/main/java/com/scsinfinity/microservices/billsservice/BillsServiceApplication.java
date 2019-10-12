package com.scsinfinity.microservices.billsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@SpringBootApplication
@EnableDiscoveryClient
public class BillsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillsServiceApplication.class, args);
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
	   return new PropertySourcesPlaceholderConfigurer();
	}
}
