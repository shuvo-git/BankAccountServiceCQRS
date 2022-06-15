package com.example.jpapractice.command.command;

import lombok.Getter;

import java.math.BigDecimal;

public class WithdrawMoneyCommand extends BaseCommand<String> {

    @Getter
    private final BigDecimal amount;

    public WithdrawMoneyCommand(String id, BigDecimal amount) {
        super(id);
        this.amount = amount;
    }


}
