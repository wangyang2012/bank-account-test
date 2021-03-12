package com.bank.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Getter
public class Account {
    private Long id;
    @Setter
    private BigDecimal balance;
    private List<Operation> operations;
}
