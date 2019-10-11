package com.scsinfinity.microservices.accountservice.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scsinfinity.microservices.accountservice.domain.AccountDomain;
import com.scsinfinity.microservices.accountservice.service.interfaces.IAccountService;

@RestController
public class AccountController {

	private final Logger logger= LoggerFactory.getLogger(AccountController.class);
	private final IAccountService accountService;
	public AccountController(IAccountService accountService) {
		super();
		this.accountService = accountService;
	}
	
	@GetMapping("/accounts/{cardNo}")
	public AccountDomain findAccountForCardNo(@PathVariable String cardNo) {
		logger.info("AccountController->findAccountForCardNo :",cardNo);
		return accountService.findByCardNo(cardNo);
	}
	
	@PostMapping("/accounts/id/{id}/balance/{requestedAmt}")
	public AccountDomain deductFromBalance(@PathVariable("requestedAmt") BigDecimal requestedAmt,@PathVariable("id") Long id) {
		logger.info("AccountController->deductFromBalance :",requestedAmt);
		return accountService.deductFromBalance(requestedAmt, id);
	}
}
