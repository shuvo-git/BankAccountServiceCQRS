package com.example.jpapractice.service;

import com.example.jpapractice.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class EventService {

    @Autowired
    private EntityManager em;

    public void save(Event e){

    }
}
