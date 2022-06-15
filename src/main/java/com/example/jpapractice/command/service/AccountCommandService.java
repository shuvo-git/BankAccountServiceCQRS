package com.example.jpapractice.command.service;

import com.example.jpapractice.command.command.CreateAccountCommand;
import com.example.jpapractice.command.command.DepositMoneyCommand;
import com.example.jpapractice.command.command.WithdrawMoneyCommand;
import com.example.jpapractice.command.dto.CreateAccountRequest;
import com.example.jpapractice.command.dto.DepositRequest;
import com.example.jpapractice.command.dto.WithdrawRequest;
import lombok.Data;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Data
@Service
public class AccountCommandService {
    private final CommandGateway commandGateway;

    public CompletableFuture<String> createAccount(CreateAccountRequest request){
        return commandGateway.send(new CreateAccountCommand(
                UUID.randomUUID().toString(),
                request.getStartingBalance()
        ));
    }

    public CompletableFuture<String> depositToAccount(DepositRequest request){
        return commandGateway.send(new DepositMoneyCommand(
                request.getAccountId(),
                request.getAmount()
        ));
    }

    public CompletableFuture<String> withdrawFromAccount(WithdrawRequest request){
        return commandGateway.send(new WithdrawMoneyCommand(
                request.getAccountId(),
                request.getAmount()
        ));
    }
}
