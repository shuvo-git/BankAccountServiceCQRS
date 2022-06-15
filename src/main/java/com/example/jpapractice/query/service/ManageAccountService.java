package com.example.jpapractice.query.service;

import com.example.jpapractice.common.event.AccountActivatedEvent;
import com.example.jpapractice.common.event.AccountCreatedEvent;
import com.example.jpapractice.common.event.AccountCreditedEvent;
import com.example.jpapractice.common.event.AccountDebitedEvent;
import com.example.jpapractice.query.entity.Account;
import com.example.jpapractice.query.query.FindAccountByIdQuery;
import com.example.jpapractice.query.repository.AccountRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ManageAccountService {
    private final AccountRepository accountRepository;

    @EventHandler
    public void on(AccountCreatedEvent accountCreatedEvent){
        log.info("Handling AccountCreatedEvent...");

        Account account = new Account();
        account.setAccountId(accountCreatedEvent.getId());
        account.setBalance(accountCreatedEvent.getBalance());
        account.setStatus(AccountCreatedEvent.STATUS_CREATED);

        accountRepository.save(account);
    }

    @EventHandler
    public void on(AccountActivatedEvent accountActivatedEvent){
        log.info("Handling AccountActivatedEvent...");

        Optional<Account> account = accountRepository.findById(accountActivatedEvent.getId());
        if(account.isPresent())
        {
            Account account1 = account.get();
            account1.setStatus(AccountActivatedEvent.STATUS_ACTIVATED);
            accountRepository.save(account1);
        }
        else {
            log.info("Account not found....");
        }
    }

    @EventHandler
    public void on(AccountCreditedEvent accountCreditedEvent){
        log.info("Handling AccountCreditedEvent...");

        Account account = accountRepository.findById(accountCreditedEvent.getId()).orElse(null);
        if(account!=null)
        {
            account.setBalance(account.getBalance().add(accountCreditedEvent.getAmount()));
            accountRepository.save(account);
        }
        else {
            log.info("Account not found....");
        }
    }

    @EventHandler
    public void on(AccountDebitedEvent accountDebitedEvent){
        log.info("Handling AccountDebitedEvent...");

        Account account = accountRepository.findById(accountDebitedEvent.getId()).orElse(null);
        if(account!=null)
        {
            account.setBalance(account.getBalance().subtract(accountDebitedEvent.getAmount()));
            accountRepository.save(account);
        }
        else {
            log.info("Account not found....");
        }
    }

    @QueryHandler
    public Account handle(FindAccountByIdQuery query){
        log.info("Handle FindAccountByIdQuery...");
        Account account = accountRepository.findById(query.getAccountId()).orElse(null);

        return account;
    }


}
