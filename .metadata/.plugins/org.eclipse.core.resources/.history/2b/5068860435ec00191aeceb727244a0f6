package com.scsinfinity.microservices.billsservice.configuration;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties("bills-service")
@Setter
@Getter
public class BillsConfiguration {
	private Integer maximumBills;
	private List<Integer> denominations; 
}
