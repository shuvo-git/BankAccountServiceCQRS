package com.example.jpapractice.command.command;

import lombok.Getter;

import java.math.BigDecimal;

public class DepositMoneyCommand extends BaseCommand<String>{
    @Getter
    private final BigDecimal amount;

    public DepositMoneyCommand(String id, BigDecimal amount) {
        super(id);
        this.amount = amount;
    }
}
