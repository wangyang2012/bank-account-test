package com.bank.service;

import com.bank.model.Account;
import com.bank.model.Operation;
import com.bank.model.OperationActionEnum;
import com.bank.model.exception.BankException;

import java.math.BigDecimal;

public interface IOperationService {
	Operation createOperation(Account account, OperationActionEnum action, BigDecimal amount) throws BankException;
}
