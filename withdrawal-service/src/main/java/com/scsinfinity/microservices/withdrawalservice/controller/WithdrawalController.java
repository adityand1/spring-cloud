package com.scsinfinity.microservices.withdrawalservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.scsinfinity.microservices.withdrawalservice.dto.AccountInformation;
import com.scsinfinity.microservices.withdrawalservice.service.interfaces.IWithdrawalService;

@RestController
public class WithdrawalController {
	private final Logger logger= LoggerFactory.getLogger(WithdrawalController.class); 
	private final IWithdrawalService withdrawalService;
	
	
	public WithdrawalController(IWithdrawalService withdrawalService) {
		super();
		this.withdrawalService = withdrawalService;
	}


	@GetMapping("/withdrawal/account-info/{cardNo}")
	public AccountInformation getInfoByCard(@PathVariable String cardNo) {
		logger.info("WithdrawalController->getInfoByCard :",cardNo);
		return withdrawalService.findByCardNo(cardNo);
	}
}
