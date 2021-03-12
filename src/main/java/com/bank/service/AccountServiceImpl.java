package com.bank.service;

import com.bank.model.Account;
import com.bank.model.exception.BankException;
import com.bank.model.exception.BusinessException;
import com.bank.model.exception.TechnicalException;
import com.bank.utils.IdUtil;

import java.math.BigDecimal;
import java.util.ArrayList;

public class AccountServiceImpl implements IAccountService {

	@Override
	public Account createAccount(BigDecimal balance) throws BankException {
		if (balance == null) {
			throw new TechnicalException("Balance cannot be null");
		}
		if (balance.compareTo(BigDecimal.ZERO) < 0) {
			throw new BusinessException("Balance cannot be negative");
		}
		return new Account(IdUtil.getNextAccountId(), balance, new ArrayList<>());
	}

	@Override
	public void deposit(Account account, BigDecimal amount) throws BankException {

	}
}
