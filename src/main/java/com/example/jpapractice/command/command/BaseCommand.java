package com.example.jpapractice.command.command;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@RequiredArgsConstructor
@Data
public class BaseCommand<T> {

    @TargetAggregateIdentifier
    private final T id;

}
