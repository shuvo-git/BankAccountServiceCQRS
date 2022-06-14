package com.example.jpapractice.common.event;

public class AccountActivatedEvent extends BaseEvent<String>{
    private final String status = "ACTIVATED";
    public AccountActivatedEvent(String id){
        super(id);
    }
}
