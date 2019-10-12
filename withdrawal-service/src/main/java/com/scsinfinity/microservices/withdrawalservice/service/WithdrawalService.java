package com.scsinfinity.microservices.withdrawalservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.scsinfinity.microservices.withdrawalservice.dto.AccountInformation;
import com.scsinfinity.microservices.withdrawalservice.service.interfaces.IWithdrawalService;
import com.scsinfinity.microservices.withdrawalservice.serviceClient.AccountServiceProxy;

@Service
public class WithdrawalService implements IWithdrawalService {

	private final Logger logger= LoggerFactory.getLogger(WithdrawalService.class);
	private final AccountServiceProxy accountService;
	
	public WithdrawalService(AccountServiceProxy accountService) {
		super();
		this.accountService = accountService;
	}

	@Override
	public AccountInformation findByCardNo(String cardNo) {
		logger.info("WithdrawalService->findByCardNo :",cardNo);
		return accountService.findAccountForCardNo(cardNo);
	}

}
