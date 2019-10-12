package com.scsinfinity.microservices.withdrawalservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableFeignClients("com.scsinfinity.microservices.withdrawalservice")
@EnableDiscoveryClient
public class WithdrawalServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WithdrawalServiceApplication.class, args);
	}

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
