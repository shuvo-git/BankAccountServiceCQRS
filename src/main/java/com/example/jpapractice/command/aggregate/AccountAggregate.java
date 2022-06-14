package com.example.jpapractice.command.aggregate;

import com.example.jpapractice.command.command.CreateAccountCommand;
import com.example.jpapractice.common.event.AccountCreatedEvent;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
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
                createAccountCommand.getId()
        ));
    }

}
