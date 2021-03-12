package com.bank.service;

import com.bank.model.Customer;
import com.bank.model.exception.BankException;

public interface ICustomerService {
	Customer createCustomer(String name) throws BankException;
}
