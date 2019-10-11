package com.scsinfinity.microservices.accountservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scsinfinity.microservices.accountservice.domain.AccountDomain;

@Repository
public interface AccountRepository extends JpaRepository<AccountDomain, Long>{
	Optional<AccountDomain> findByCardNo(String cardNo);
}
