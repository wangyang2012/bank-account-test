package com.bank.service;

import com.bank.model.Customer;
import com.bank.model.exception.TechnicalException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class CustomerServiceTest {

    private ICustomerService customerService = new CustomerServiceImpl();
    private IAccountService accountService = new AccountServiceImpl();

    // Create customer tests
    @Test
    void create_customer_with_correct_data() throws Exception {
        Customer customer = this.customerService.createCustomer("customer1");
        Assertions.assertNotNull(customer);
        Assertions.assertEquals("customer1", customer.getName());
        Assertions.assertNotNull(customer.getAccount());
    }

    @Test
    void create_customer_with_null_expect_technical_exception() {
        Assertions.assertThrows(TechnicalException.class, () -> {
            this.customerService.createCustomer(null);
        });
    }

    // Print balance tests
    @Test
    void print_balance_with_correct_data() throws Exception {
        Customer customer = this.customerService.createCustomer("customer1");
        this.accountService.deposit(customer.getAccount(), BigDecimal.TEN);
        this.accountService.deposit(customer.getAccount(), BigDecimal.TEN);
        this.accountService.withdrawal(customer.getAccount(), BigDecimal.TEN);
        this.customerService.printCustomerBalance(customer);
    }

    @Test
    void print_balance_with_null_expect_exception() {
        Assertions.assertThrows(TechnicalException.class, () -> {
            this.customerService.printCustomerBalance(null);
        });
    }
}
