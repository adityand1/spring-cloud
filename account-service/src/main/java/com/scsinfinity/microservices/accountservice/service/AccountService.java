package com.scsinfinity.microservices.accountservice.service;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.scsinfinity.microservices.accountservice.domain.AccountDomain;
import com.scsinfinity.microservices.accountservice.repository.AccountRepository;
import com.scsinfinity.microservices.accountservice.service.interfaces.IAccountService;
@Service
public class AccountService implements IAccountService {
	private final Logger logger = LoggerFactory.getLogger(AccountService.class);
	
	private final AccountRepository accountRepository;
	
	
	public AccountService(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}

	@Override
	@Transactional
	public AccountDomain save(AccountDomain accountDomain) {
		logger.info("AccountService->save :",accountDomain);
		return accountRepository.save(accountDomain);
	}

	@Override
	public AccountDomain findByCardNo(String cardNo) {
		logger.info("AccountService->findByCardNo :",cardNo);
		return accountRepository.findByCardNo(cardNo).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public List<AccountDomain> saveAll(List<AccountDomain> accountDomains) {
		logger.info("AccountService->saveAll :",accountDomains);
		return accountRepository.saveAll(accountDomains);
	}

	@Override
	public AccountDomain deductFromBalance(BigDecimal requestedAmt,Long id) {
		AccountDomain account= accountRepository.findById(id).orElseThrow(EntityNotFoundException::new);
		return account.getBalance().compareTo(requestedAmt)>0
				?deduct(account,requestedAmt)
				:AccountDomain.builder().defaultData(true).build();
			
	}

	@Override
	public List<AccountDomain> findAll() {
		return accountRepository.findAll();
	}
	
	private AccountDomain deduct(AccountDomain account, BigDecimal deductableAmt) {
		return accountRepository.save(AccountDomain.builder().balance(account.getBalance().subtract(deductableAmt))
					.id(account.getId())
					.cardNo(account.getCardNo())
					.name(account.getName())
					.dateOfExpiryOfCard(account.getDateOfExpiryOfCard())
					.defaultData(account.getDefaultData())
					.build());
	}

}
