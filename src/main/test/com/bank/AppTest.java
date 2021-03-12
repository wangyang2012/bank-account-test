package com.bank;

import com.bank.model.Account;
import com.bank.model.Customer;
import com.bank.service.AccountServiceImpl;
import com.bank.service.CustomerServiceImpl;
import com.bank.service.IAccountService;
import com.bank.service.ICustomerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * Unit test for simple App.
 */
@Slf4j
class AppTest
{
    private ICustomerService customerService = new CustomerServiceImpl();
    private IAccountService accountService = new AccountServiceImpl();

    /**
     * Integration scenario test
     */
    @Test
    void should_create_operations_and_print() throws Exception {
        Customer customer = this.customerService.createCustomer("Customer");
        Account account = customer.getAccount();
        this.accountService.deposit(account, BigDecimal.TEN);
        this.accountService.withdrawal(account, BigDecimal.TEN);
        this.accountService.deposit(account, BigDecimal.ONE);
        this.accountService.deposit(account, BigDecimal.TEN);
        this.accountService.withdrawal(account, BigDecimal.ONE);
        this.customerService.printCustomerBalance(customer);

        // assertions
        Assertions.assertEquals(BigDecimal.TEN, account.getBalance());
    }
}
