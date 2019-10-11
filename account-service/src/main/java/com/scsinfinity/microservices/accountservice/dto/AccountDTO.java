package com.scsinfinity.microservices.accountservice.dto;

import java.math.BigDecimal;
import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AccountDTO {
	private Long id;

	private String name;

	private String cardNo;

	private Instant dateOfExpiryOfCard;

	private BigDecimal balance;

	private Boolean defaultData;

	private Integer port;
	
}
