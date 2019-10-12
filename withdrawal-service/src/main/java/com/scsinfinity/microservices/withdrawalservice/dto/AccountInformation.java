package com.scsinfinity.microservices.withdrawalservice.dto;

import java.math.BigDecimal;
import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AccountInformation {

	private Long id;

	private String name;

	private String cardNo;

	private Instant dateOfExpiryOfCard;

	private BigDecimal balance;

	private Boolean defaultData;
	
	private Integer port;
}
