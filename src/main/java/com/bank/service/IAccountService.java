package com.bank.service;

import com.bank.model.Account;
import com.bank.model.exception.BankException;
import java.math.BigDecimal;

public interface IAccountService {
    Account createAccount(BigDecimal balance) throws BankException;

    /**
     * Deposite amount to account
     * @param account
     * @param amount
     * @throws Exception
     */
    void deposit(Account account, BigDecimal amount) throws BankException;

    /**
     * Withdrawal amount from account
     * @param account
     * @param amount
     * @throws Exception
     */
    void withdrawal(Account account, BigDecimal amount) throws BankException;
}
