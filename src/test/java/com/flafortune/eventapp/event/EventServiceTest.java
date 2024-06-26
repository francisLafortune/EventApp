package com.flafortune.eventapp.event;

import com.flafortune.eventapp.IntegrationTest;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.jdbc.Sql;

import java.time.Instant;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Sql("/insert_events.sql")
class EventServiceTest extends IntegrationTest {

    @Autowired
    EventRepository eventRepository;
    @Autowired
    private EventService eventService;

    private static @NotNull Event getEvent(String name) {
        return new Event(
                name,
                "My new event description",
                Instant.parse("2024-01-01T16:00:00Z"),
                Instant.parse("2024-01-01T18:00:00Z")
        );
    }

    @Test
    void getEvents() {
        List<Event> events = eventService.getEvents();
        assertEquals(2, events.size());
        assertEquals("event 1", events.get(0).getName());
    }

    @Test
    void createEvent() {

        Event event = getEvent("My new Event");

        EventEntity entity = eventService.createEvent(event);
        List<Event> events = eventService.getEvents();

        assertEquals(3, events.size());
        assertEquals("My new event", events.get(2).getName());
        assertEquals(3, entity.getId());
    }

    @Test
    void createEventWithNameLongerThan32CharactersShouldThrowException() {
        Event event = getEvent("My new Event with a name longer than 32 characters");

        assertThrows(DataIntegrityViolationException.class, () -> {
            eventService.createEvent(event);
        });
    }

    @Test
    void timeZonesAreProperlyManaged() {

        //TODO


    }

}