package com.bank.utils;

/**
 * Utility class to get next ids for customers, accounts and operations
 */
public class IdUtil {
    private static Long accountId = 1L;
    private static Long customerId = 1L;
    private static Long operationId = 1L;

    private IdUtil() {}

    public static Long getNextAccountId() {
        accountId++;
        return accountId;
    }

    public static Long getNextCustomerId() {
        customerId++;
        return customerId;
    }

    public static Long getNextOperationId() {
        operationId++;
        return operationId;
    }
}
