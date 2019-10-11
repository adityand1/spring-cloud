package com.scsinfinity.microservices.accountservice.domain;

import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class AccountDomain {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private String cardNo;
	
	private Instant dateOfExpiryOfCard;
	
	private BigDecimal balance;
	
	private Boolean defaultData;
	
	private Integer dataVersion;
	
}
