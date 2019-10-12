package com.scsinfinity.microservices.billsservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.scsinfinity.microservices.billsservice.configuration.BillsConfiguration;
import com.scsinfinity.microservices.billsservice.domain.BillsDTO;
import com.scsinfinity.microservices.billsservice.service.interfaces.IBillsService;
@Service
public class BillsService implements IBillsService {
	
	private final Logger logger= LoggerFactory.getLogger(BillsService.class);
	
	private final BillsConfiguration billsConfiguration;
	private final Environment environment;
	
	


	public BillsService(BillsConfiguration billsConfiguration, Environment environment) {
		super();
		this.billsConfiguration = billsConfiguration;
		this.environment = environment;
	}




	@Override
	public BillsDTO getBillsInfo() {
		logger.info("BillsService->getBillsInfo");
		return new BillsDTO(billsConfiguration.getMaximumBills(),billsConfiguration.getDenominations(),Integer.parseInt(environment.getProperty("local.server.port")));
		//return new BillsDTO(billsConfiguration.getMaximumBills());
	}

}
