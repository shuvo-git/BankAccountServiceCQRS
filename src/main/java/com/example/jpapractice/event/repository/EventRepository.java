package com.example.jpapractice.event.repository;

import com.example.jpapractice.event.model.Event;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class EventRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void saveEvent(Event event) {
        entityManager.persist(event);
    }

    public List<Event> getAllEvents(){
        String jpql = "SELECT c FROM Event c";
        TypedQuery<Event> query = entityManager.createQuery(jpql, Event.class);

        return query.getResultList();
    }
}
