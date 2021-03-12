package com.bank;

import com.bank.model.Account;
import com.bank.model.Customer;
import com.bank.model.exception.BankException;
import com.bank.service.AccountServiceImpl;
import com.bank.service.CustomerServiceImpl;
import com.bank.service.IAccountService;
import com.bank.service.ICustomerService;

import java.math.BigDecimal;

public class ApplicationDemo {

    private ICustomerService customerService = new CustomerServiceImpl();
    private IAccountService accountService = new AccountServiceImpl();

    public void demo() throws BankException {
        Customer customer = this.customerService.createCustomer("Customer");
        Account account = customer.getAccount();
        this.accountService.deposit(account, BigDecimal.TEN);
        this.accountService.withdrawal(account, BigDecimal.TEN);
        this.accountService.deposit(account, BigDecimal.ONE);
        this.accountService.deposit(account, BigDecimal.TEN);
        this.accountService.withdrawal(account, BigDecimal.ONE);
        this.customerService.printCustomerBalance(customer);
    }
}
