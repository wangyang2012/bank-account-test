package com.bank.service;

import com.bank.model.Account;
import com.bank.model.Operation;
import com.bank.model.OperationActionEnum;
import com.bank.model.exception.BusinessException;
import com.bank.model.exception.TechnicalException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

class OperationServiceTest {
    private IOperationService operationService = new OperationServiceImpl();

    // Create operation tests
    @Test
    void create_operation_with_correct_data() throws Exception {
        Account account = new Account(1L, BigDecimal.ZERO, new ArrayList<>());
        Operation operation = this.operationService.createOperation(account, OperationActionEnum.DEPOSIT, BigDecimal.TEN);
        Assertions.assertNotNull(operation);
        Assertions.assertEquals(OperationActionEnum.DEPOSIT, operation.getAction());
        Assertions.assertEquals(BigDecimal.TEN, operation.getAmount());
    }

    @Test
    void create_operation_with_null_expect_technical_exception() {
        Assertions.assertThrows(TechnicalException.class, () -> {
            this.operationService.createOperation(null, null, null);
        });
    }

    @Test
    void create_operation_with_wrong_amount_expect_business_exception() {
        Account account = new Account(1L, BigDecimal.ZERO, new ArrayList<>());
        Assertions.assertThrows(BusinessException.class, () -> {
            this.operationService.createOperation(account, OperationActionEnum.DEPOSIT, new BigDecimal(-1));
        });
    }

    // Print operation tests
    @Test
    void print_operation_with_correct_data() throws Exception {
        Account account = new Account(1L, BigDecimal.ZERO, new ArrayList<>());
        Operation operation = this.operationService.createOperation(account, OperationActionEnum.DEPOSIT, BigDecimal.TEN);
        this.operationService.printOperationToString(operation);
    }

    @Test
    void print_operation_with_null_expect_exception() {
        Assertions.assertThrows(TechnicalException.class, () -> {
            this.operationService.printOperationToString(null);
        });
    }
}
