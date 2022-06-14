package com.example.jpapractice.controller;

import com.example.jpapractice.Errors.error.ErrorModel;
import com.example.jpapractice.Errors.error.ErrorResponse;
import com.example.jpapractice.model.Event;
import com.example.jpapractice.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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
