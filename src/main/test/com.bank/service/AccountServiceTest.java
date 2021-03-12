package com.bank.service;

import com.bank.model.Account;
import com.bank.model.exception.BusinessException;
import com.bank.model.exception.TechnicalException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class AccountServiceTest {
    private IAccountService accountService = new AccountServiceImpl();

    // Create account tests
    @Test
    public void create_account_with_correct_data() throws Exception {
        Account account = this.accountService.createAccount(BigDecimal.TEN);
        Assertions.assertNotNull(account);
        Assertions.assertEquals(BigDecimal.TEN, account.getBalance());
        Assertions.assertNotNull(account.getOperations());
        Assertions.assertEquals(0, account.getOperations().size());
    }

    @Test
    public void create_account_with_null_expect_technical_exception() {
        Assertions.assertThrows(TechnicalException.class, () -> {
            this.accountService.createAccount(null);
        });
    }

    @Test
    public void create_account_with_negative_amount_expect_business_exception() {
        Assertions.assertThrows(BusinessException.class, () -> {
            this.accountService.createAccount(new BigDecimal(-1));
        });
    }
}
