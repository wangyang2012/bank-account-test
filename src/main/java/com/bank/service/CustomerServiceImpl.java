package com.bank.service;

import com.bank.model.Customer;
import com.bank.model.exception.BankException;
import com.bank.model.exception.TechnicalException;
import com.bank.utils.IdUtil;
import org.apache.commons.lang3.StringUtils;
import java.math.BigDecimal;

public class CustomerServiceImpl implements ICustomerService {

	private IAccountService accountService = new AccountServiceImpl();

	@Override
	public Customer createCustomer(String name) throws BankException {
		if (StringUtils.isBlank(name)) {
			throw new TechnicalException("Name cannot be null");
		}
		return new Customer(IdUtil.getNextCustomerId(), name, accountService.createAccount(BigDecimal.ZERO));
	}

	@Override
	public void printCustomerBalance(Customer customer) throws BankException {

	}
}
