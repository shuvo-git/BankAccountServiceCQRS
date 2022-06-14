package com.example.jpapractice.event.service;

import com.example.jpapractice.event.model.Event;
import com.example.jpapractice.event.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
