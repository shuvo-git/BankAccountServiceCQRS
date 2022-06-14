package com.example.jpapractice.query.controller;

import com.example.jpapractice.query.entity.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manage-account")
public class ManageAccountController {
    @GetMapping("/get-account")
    public ResponseEntity<Account> getAccount(@RequestParam String id){
        return null;
    }
}
