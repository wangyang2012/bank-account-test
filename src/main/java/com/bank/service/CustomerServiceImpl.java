package com.bank.service;

import com.bank.model.Customer;
import com.bank.model.Operation;
import com.bank.model.exception.BankException;
import com.bank.model.exception.TechnicalException;
import com.bank.utils.IdUtil;
import org.apache.commons.lang3.StringUtils;
import java.math.BigDecimal;
import java.util.logging.Logger;

public class CustomerServiceImpl implements ICustomerService {

	private IAccountService accountService = new AccountServiceImpl();
	private IOperationService operationService = new OperationServiceImpl();
	private static final Logger LOGGER = Logger.getLogger(CustomerServiceImpl.class.getName());

	@Override
	public Customer createCustomer(String name) throws BankException {
		if (StringUtils.isBlank(name)) {
			throw new TechnicalException("Name cannot be null");
		}
		return new Customer(IdUtil.getNextCustomerId(), name, accountService.createAccount(BigDecimal.ZERO));
	}

	@Override
	public void printCustomerBalance(Customer customer) throws BankException {
		if (customer == null) {
			throw new TechnicalException("Customer cannot be null");
		}

		StringBuilder sb = new StringBuilder();
		sb.append("******* BANK ACCOUNT INFORMATION ******\n");
		sb.append("Customer: " + customer.getName() + "\n");
		sb.append("Account number: " + customer.getAccount().getId() + "\n");
		for (Operation operation : customer.getAccount().getOperations()) {
			sb.append(this.operationService.printOperationToString(operation) + "\n");
		}
		sb.append("Balance: " + customer.getAccount().getBalance().setScale(2) + "\n");
		LOGGER.info(sb.toString());
	}
}
