package com.flafortune.eventapp.event;

import com.flafortune.eventapp.util.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getEvents() {
        return eventRepository
                .findAll()
                .stream()
                .map(EventMapper::toEvent)
                .toList();
    }

    public EventEntity createEvent(Event event) {
        return eventRepository.save(EventMapper.toEntity(event));
    }

    public Event findById(long id) {
        Optional<EventEntity> eventEntity = eventRepository.findById(id);
        if (eventEntity.isPresent()) {
            return EventMapper.toEvent(eventEntity.get());
        }
        throw new ResourceNotFoundException();
    }

}
