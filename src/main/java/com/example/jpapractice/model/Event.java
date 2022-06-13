package com.example.jpapractice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "events")
@Data
public class Event {
    @Id
    private String id;

    private int status;
}
