package com.scsinfinity.microservices.billsservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.scsinfinity.microservices.billsservice.configuration.BillsConfiguration;
import com.scsinfinity.microservices.billsservice.domain.BillsDTO;
import com.scsinfinity.microservices.billsservice.service.interfaces.IBillsService;
@Service
public class BillsService implements IBillsService {
	
	private final Logger logger= LoggerFactory.getLogger(BillsService.class);
	
	private final BillsConfiguration billsConfiguration;
	
	
	public BillsService(BillsConfiguration billsConfiguration) {
		super();
		this.billsConfiguration = billsConfiguration;
	}


	@Override
	public BillsDTO getBillsInfo() {
		logger.info("BillsService->getBillsInfo");
		return new BillsDTO(billsConfiguration.getMaximumBills(),billsConfiguration.getDenominations());
		//return new BillsDTO(billsConfiguration.getMaximumBills());
	}

}