package com.scsinfinity.microservices.accountservice.service.interfaces;

import java.math.BigDecimal;
import java.util.List;

import com.scsinfinity.microservices.accountservice.domain.AccountDomain;

public interface IAccountService {
	
	AccountDomain save(AccountDomain accountDomain);
	List<AccountDomain> saveAll(List<AccountDomain> accountDomains);
	AccountDomain findByCardNo(String cardNo);
	List<AccountDomain> findAll();
	AccountDomain deductFromBalance(BigDecimal requestedAmt, Long id);
}
