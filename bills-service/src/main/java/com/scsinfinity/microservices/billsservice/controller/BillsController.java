package com.scsinfinity.microservices.billsservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scsinfinity.microservices.billsservice.domain.BillsDTO;
import com.scsinfinity.microservices.billsservice.service.interfaces.IBillsService;

@RestController
public class BillsController {

	private final Logger logger= LoggerFactory.getLogger(BillsController.class);
	private final IBillsService billsService;
	
	
	public BillsController(IBillsService billsService) {
		super();
		this.billsService = billsService;
	}
	
	@GetMapping("/bills")
	public BillsDTO retrieveBillListFromConfigurations() {
		logger.info("BillsController->retrieveBillListFromConfigurations");
		return billsService.getBillsInfo();
	}
	
	
}
