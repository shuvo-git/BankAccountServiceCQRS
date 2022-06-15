package com.example.jpapractice.common.event;

import lombok.Getter;

import java.math.BigDecimal;

public class AccountDebitedEvent extends BaseEvent<String>{

    public static final String STATUS_DEBITED = "DEBITED";

    @Getter
    private final BigDecimal amount;
    public AccountDebitedEvent(String id, BigDecimal amount){
        super(id);
        this.amount = amount;
    }
}
