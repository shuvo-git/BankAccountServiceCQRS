package com.example.jpapractice.common.event;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BaseEvent<T> {

    @Getter
    final T id;

}
