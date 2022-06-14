package com.example.jpapractice.query.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
public class Account {
    @Id
    private String AccountId;
    private BigDecimal balance;
    private String status;
}
