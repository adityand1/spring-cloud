package com.scsinfinity.microservices.accountservice.configuration;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.scsinfinity.microservices.accountservice.domain.AccountDomain;
import com.scsinfinity.microservices.accountservice.service.interfaces.IAccountService;

@Component
public class AccountInitData implements CommandLineRunner{

	private final Logger logger= LoggerFactory.getLogger(AccountInitData.class);
	
	private final IAccountService accountService;
	
	public AccountInitData(IAccountService accountService) {
		super();
		this.accountService = accountService;
	}

	@Override
	public void run(String... args) throws Exception {
		if(accountService.findAll().size()>0)
			return;
		AccountDomain accountDomain1=AccountDomain.builder()
				.name("Abhijeet Sinha")
				.cardNo("773335x33")
				.dateOfExpiryOfCard(Instant.now().plus(600L,ChronoUnit.DAYS))
				.balance(BigDecimal.valueOf(100000L)).defaultData(false).dataVersion(1).build();
		
		AccountDomain accountDomain2=AccountDomain.builder()
				.name("Sujeet Sharma")
				.cardNo("77385c293")
				.dateOfExpiryOfCard(Instant.now().plus(600L,ChronoUnit.DAYS))
				.balance(BigDecimal.valueOf(120000L)).defaultData(false).dataVersion(1).build();
		
		AccountDomain accountDomain3=AccountDomain.builder()
				.name("Raina  Kumari")
				.cardNo("9903855s1")
				.dateOfExpiryOfCard(Instant.now().plus(600L,ChronoUnit.DAYS))
				.balance(BigDecimal.valueOf(180000L)).defaultData(false).dataVersion(1).build();
		List<AccountDomain> accounts= Arrays.asList(accountDomain1,accountDomain2,accountDomain3);
		logger.info("AccountInitData->Setting initial accounts: ",accounts);
		accountService.saveAll(accounts);
		
	}

	
}
