package com.example.jpapractice.common.event;

public class AccountCreatedEvent extends BaseEvent<String>{
    private final String status = "CREATED";
    public AccountCreatedEvent(String id){
        super(id);
    }
}
