package com.flafortune.eventapp.event;

import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EventMapperTest {

    @Test
    void eventAreProperlyMappedToEntity() {

        Event event = new Event();

        event.setName("Event to entity");
        event.setDescription("Event to entity test");
        event.setBeginTimestamp(Instant.parse("2024-01-01T16:00:00Z").getEpochSecond());
        event.setEndTimestamp(Instant.parse("2024-01-01T18:00:00Z").getEpochSecond());


        EventEntity eventEntity = EventMapper.toEntity(event);
        assertEquals("Event to entity", eventEntity.getName());
        assertEquals("Event to entity test", eventEntity.getDescription());
        assertEquals(Instant.parse("2024-01-01T16:00:00Z"), eventEntity.getBeginTime());
        assertEquals(Instant.parse("2024-01-01T18:00:00Z"), eventEntity.getEndTime());

    }

    @Test
    void entityAreProperlyMappedToEvent() {
        EventEntity entity = new EventEntity();
        entity.setName("Entity to event");
        entity.setDescription("Entity to event test");
        entity.setBeginTime(Instant.parse("2024-08-01T16:00:00Z"));
        entity.setEndTime(Instant.parse("2024-08-01T18:00:00Z"));

        Event event = EventMapper.toEvent(entity);
        assertEquals("Entity to event", event.getName());
        assertEquals("Entity to event test", event.getDescription());
        assertEquals(Instant.parse("2024-08-01T16:00:00Z"), Instant.ofEpochSecond(event.getBeginTimestamp()));
        assertEquals(Instant.parse("2024-08-01T18:00:00Z"), Instant.ofEpochSecond(event.getEndTimestamp()));
    }

}