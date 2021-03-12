package com.bank.service;

import com.bank.model.Account;
import com.bank.model.Operation;
import com.bank.model.OperationActionEnum;
import com.bank.model.exception.BankException;
import com.bank.model.exception.BusinessException;
import com.bank.model.exception.TechnicalException;
import com.bank.utils.IdUtil;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OperationServiceImpl implements IOperationService {

	@Override
	public Operation createOperation(Account account, OperationActionEnum action, BigDecimal amount) throws BankException {
		if (account == null || action == null || amount == null) {
			throw new TechnicalException("Account, action and amount cannot be null");
		}
		if (amount.compareTo(BigDecimal.ZERO) < 0) {
			throw new BusinessException("Amount cannot be negative");
		}
		Operation operation = new Operation(IdUtil.getNextOperationId(), action, amount, LocalDateTime.now());
		account.getOperations().add(operation);
		return operation;
	}

	@Override
	public String printOperationToString(Operation operation) throws BankException {
		if (operation == null) {
			throw new TechnicalException("Operation cannot be null");
		}
		StringBuilder sb = new StringBuilder();
		sb.append(operation.getDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		sb.append("\t\t");
		sb.append(operation.getAction());
		sb.append("\t");
		if (OperationActionEnum.DEPOSIT.equals(operation.getAction())) {
			sb.append("\t");
		}
		sb.append(operation.getAmount().setScale(2));
		return sb.toString();
	}

}
