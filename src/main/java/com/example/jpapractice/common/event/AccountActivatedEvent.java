package com.example.jpapractice.common.event;

import lombok.Getter;

public class AccountActivatedEvent extends BaseEvent<String>{
    public static final String STATUS_ACTIVATED = "ACTIVATED";
    public AccountActivatedEvent(String id){
        super(id);
    }
}
