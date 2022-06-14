package com.example.jpapractice.event.controller;

import com.example.jpapractice.event.model.Event;
import com.example.jpapractice.event.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/events")
public class HelloController {

    @Autowired
    private EventService eventService;

    @PostMapping("/create")
    public void create(@Valid @RequestBody Event event){
        eventService.save(event);
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAll(){
        return ResponseEntity.ok().body(eventService.getAll());
    }
}
