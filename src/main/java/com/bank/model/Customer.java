package com.bank.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Customer {
    private Long id;
    private String name;
    private Account account;
}
