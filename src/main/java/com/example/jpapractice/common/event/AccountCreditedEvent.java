package com.example.jpapractice.common.event;

import lombok.Getter;

import java.math.BigDecimal;

public class AccountCreditedEvent extends BaseEvent<String>{
    public static final String STATUS_CREDITED = "CREDITED";
    @Getter
    private final BigDecimal amount;


    public AccountCreditedEvent(String id,BigDecimal amount){
        super(id);
        this.amount = amount;
    }
}
