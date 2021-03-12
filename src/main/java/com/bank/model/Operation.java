package com.bank.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class Operation {
	private Long id;
	private OperationActionEnum action;
	private BigDecimal amount;
	private LocalDateTime dateTime;
}
