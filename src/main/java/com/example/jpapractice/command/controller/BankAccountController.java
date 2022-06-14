package com.example.jpapractice.command.controller;

import com.example.jpapractice.command.dto.CreateAccountRequest;
import com.example.jpapractice.command.dto.DepositRequest;
import com.example.jpapractice.command.dto.WithdrawRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/bank-account")
public class BankAccountController {

    @PostMapping("/create")
    public ResponseEntity<String> createAccount(@Valid @RequestBody CreateAccountRequest request){
        return null;
    }

    @PutMapping("/deposit")
    public ResponseEntity<String> deposit(@Valid @RequestBody DepositRequest request){
        return null;
    }

    @PutMapping("/withdraw")
    public ResponseEntity<String> withdraw(@Valid @RequestBody WithdrawRequest request){
        return null;
    }

}
