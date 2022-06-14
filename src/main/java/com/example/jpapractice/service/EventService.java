package com.example.jpapractice.service;

import com.example.jpapractice.model.Event;
import com.example.jpapractice.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;

    public void save(Event e){
        repository.saveEvent(e);
    }

    public List<Event> getAll(){
        return repository.getAllEvents();
    }
}
