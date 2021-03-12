package com.bank.service;

import com.bank.model.Account;
import com.bank.model.exception.BankException;
import java.math.BigDecimal;

public interface IAccountService {
    Account createAccount(BigDecimal balance) throws BankException;
}
