package com.scsinfinity.microservices.withdrawalservice.service.interfaces;

import com.scsinfinity.microservices.withdrawalservice.dto.AccountInformation;

public interface IWithdrawalService {
	
	AccountInformation findByCardNo(String cardNo);

}
