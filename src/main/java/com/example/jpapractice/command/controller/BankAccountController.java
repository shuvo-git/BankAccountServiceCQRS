package com.example.jpapractice.command.controller;

import com.example.jpapractice.command.dto.CreateAccountRequest;
import com.example.jpapractice.command.dto.DepositRequest;
import com.example.jpapractice.command.dto.WithdrawRequest;
import com.example.jpapractice.command.service.AccountCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/bank-account")
@RequiredArgsConstructor
public class BankAccountController {


    private final AccountCommandService accountCommandService;

    @PostMapping("/create")
    public ResponseEntity<String> createAccount(@Valid @RequestBody CreateAccountRequest request){
        try{
            CompletableFuture<String> response = accountCommandService.createAccount(request);

            return new ResponseEntity<>(response.get(),HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>("An Error Occured", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/deposit")
    public ResponseEntity<String> deposit(@Valid @RequestBody DepositRequest request){
        try{
            CompletableFuture<String> response = accountCommandService.depositToAccount(request);

            return new ResponseEntity<>("Account Credited",HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("An Error Occured", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/withdraw")
    public ResponseEntity<String> withdraw(@Valid @RequestBody WithdrawRequest request){
        try{
            CompletableFuture<String> response = accountCommandService.withdrawFromAccount(request);

            return new ResponseEntity<>("Account Debited",HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("An Error Occured", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
