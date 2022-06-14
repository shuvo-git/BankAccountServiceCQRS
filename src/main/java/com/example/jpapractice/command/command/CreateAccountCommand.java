package com.example.jpapractice.command.command;

import lombok.Getter;

import java.math.BigDecimal;

public class CreateAccountCommand extends BaseCommand<String>{
    @Getter
    private final BigDecimal balance;

    public CreateAccountCommand(String id, BigDecimal balance) {
        super(id);
        this.balance = balance;
    }
}
