package com.example.jpapractice.common.event;

public class AccountDebitedEvent extends BaseEvent<String>{
    private final String status = "DEBITED";
    public AccountDebitedEvent(String id){
        super(id);
    }
}
