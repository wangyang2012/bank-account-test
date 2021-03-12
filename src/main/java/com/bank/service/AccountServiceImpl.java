package com.bank.service;

import com.bank.model.Account;
import com.bank.model.OperationActionEnum;
import com.bank.model.exception.BankException;
import com.bank.model.exception.BusinessException;
import com.bank.model.exception.TechnicalException;
import com.bank.utils.IdUtil;

import java.math.BigDecimal;
import java.util.ArrayList;

public class AccountServiceImpl implements IAccountService {

	private IOperationService operationService = new OperationServiceImpl();

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
		verifyAccountAndAmount(account, amount);
		account.setBalance(account.getBalance().add(amount));
		this.operationService.createOperation(account, OperationActionEnum.DEPOSIT, amount);
	}

	@Override
	public void withdrawal(Account account, BigDecimal amount) throws BankException {
		
	}

	private void verifyAccountAndAmount(Account account, BigDecimal amount) throws TechnicalException, BusinessException {
		if (account == null || amount == null) {
			throw new TechnicalException("Account or amount cannot be null");
		}

		if (amount.compareTo(BigDecimal.ZERO) < 0) {
			throw new BusinessException("Amount cannot be negative");
		}
	}
}
