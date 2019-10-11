package com.scsinfinity.microservices.accountservice.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scsinfinity.microservices.accountservice.domain.AccountDomain;
import com.scsinfinity.microservices.accountservice.dto.AccountDTO;
import com.scsinfinity.microservices.accountservice.service.interfaces.IAccountService;

@RestController
public class AccountController {

	private final Logger logger = LoggerFactory.getLogger(AccountController.class);
	private final IAccountService accountService;
	private final Environment environment;

	public AccountController(IAccountService accountService, Environment environment) {
		super();
		this.accountService = accountService;
		this.environment = environment;
	}

	@GetMapping("/accounts/{cardNo}")
	public AccountDTO findAccountForCardNo(@PathVariable String cardNo) {
		logger.info("AccountController->findAccountForCardNo :", cardNo);
		AccountDomain accoundDomain = accountService.findByCardNo(cardNo);
		return new AccountDTO(accoundDomain.getId(), accoundDomain.getName(), accoundDomain.getCardNo(),
				accoundDomain.getDateOfExpiryOfCard(), accoundDomain.getBalance(), accoundDomain.getDefaultData(),
				Integer.parseInt(environment.getProperty("local.server.port")));
	}

	@PostMapping("/accounts/id/{id}/balance/{requestedAmt}")
	public AccountDomain deductFromBalance(@PathVariable("requestedAmt") BigDecimal requestedAmt,
			@PathVariable("id") Long id) {
		logger.info("AccountController->deductFromBalance :", requestedAmt);
		return accountService.deductFromBalance(requestedAmt, id);
	}
}
