package com.example.jpapractice.common.event;

public class AccountCreditedEvent extends BaseEvent<String>{
    private final String status = "CREDITED";
    public AccountCreditedEvent(String id){
        super(id);
    }
}
