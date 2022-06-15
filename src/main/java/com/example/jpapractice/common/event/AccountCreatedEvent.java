package com.example.jpapractice.common.event;

import lombok.Getter;

import java.math.BigDecimal;

public class AccountCreatedEvent extends BaseEvent<String>{

    public static final String STATUS_CREATED = "CREATED";

    @Getter
    private final BigDecimal balance;

    public AccountCreatedEvent(String id, BigDecimal balance){
        super(id);
        this.balance = balance;
    }
}
