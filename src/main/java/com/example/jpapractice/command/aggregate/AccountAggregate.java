package com.example.jpapractice.command.aggregate;

import com.example.jpapractice.command.command.CreateAccountCommand;
import com.example.jpapractice.command.command.DepositMoneyCommand;
import com.example.jpapractice.command.command.WithdrawMoneyCommand;
import com.example.jpapractice.common.event.AccountActivatedEvent;
import com.example.jpapractice.common.event.AccountCreatedEvent;
import com.example.jpapractice.common.event.AccountCreditedEvent;
import com.example.jpapractice.common.event.AccountDebitedEvent;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Aggregate
@Slf4j
public class AccountAggregate {

    @AggregateIdentifier
    private String AccountId;
    private BigDecimal balance;
    private String status;

    @CommandHandler
    public AccountAggregate(CreateAccountCommand createAccountCommand){
        log.info("CreateAccountCommand Received.");
        AggregateLifecycle.apply(new AccountCreatedEvent(
                createAccountCommand.getId(),
                createAccountCommand.getBalance()
        ));
    }

    @EventSourcingHandler
    public void on(AccountCreatedEvent accountCreatedEvent){
        log.info("An AccountCreatedEvent Occurred.");

        this.AccountId = accountCreatedEvent.getId();
        this.balance = accountCreatedEvent.getBalance();
        this.status = AccountCreatedEvent.STATUS_CREATED;

        AggregateLifecycle.apply(new AccountActivatedEvent(
                accountCreatedEvent.getId()
        ));
    }

    @EventSourcingHandler
    public void on(AccountActivatedEvent accountActivatedEvent){
        log.info("An AccountActivatedEvent Occurred.");

        this.status = AccountActivatedEvent.STATUS_ACTIVATED;
    }

    @CommandHandler
    public void on(DepositMoneyCommand depositMoneyCommand){
        log.info("DepositMoneyCommand Received.");
        AggregateLifecycle.apply(new AccountCreditedEvent(
                depositMoneyCommand.getId(),
                depositMoneyCommand.getAmount()
        ));
    }

    @EventSourcingHandler
    public void on(AccountCreditedEvent accountCreditedEvent){
        log.info("An AccountCreditedEvent Occurred.");

        this.balance = this.balance.add(accountCreditedEvent.getAmount());
    }

    @CommandHandler
    public void on(WithdrawMoneyCommand withdrawMoneyCommand){
        log.info("WithdrawMoneyCommand Received.");
        AggregateLifecycle.apply(new AccountDebitedEvent(
                withdrawMoneyCommand.getId(),
                withdrawMoneyCommand.getAmount()
        ));
    }

    @EventSourcingHandler
    public void on(AccountDebitedEvent accountDebitedEvent){
        log.info("An AccountDebitedEvent Occurred.");

        this.balance = this.balance.subtract(accountDebitedEvent.getAmount());
    }

}
