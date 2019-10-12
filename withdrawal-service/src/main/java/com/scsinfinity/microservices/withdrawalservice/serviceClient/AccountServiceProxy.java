package com.scsinfinity.microservices.withdrawalservice.serviceClient;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.scsinfinity.microservices.withdrawalservice.dto.AccountInformation;

//@FeignClient(name="account-service",url="localhost:8000")
@FeignClient(name="account-service")
@RibbonClient(name="account-service")
public interface AccountServiceProxy {
	@GetMapping("/accounts/{cardNo}")
	public AccountInformation findAccountForCardNo(@PathVariable String cardNo);
}
