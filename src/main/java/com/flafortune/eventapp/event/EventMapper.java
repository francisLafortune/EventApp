package com.flafortune.eventapp.event;

import java.time.Instant;

public class EventMapper {

    public static Event toEvent(EventEntity eventEntity) {
        Event event = new Event();
        event.setId(eventEntity.getId());
        event.setName(eventEntity.getName());
        event.setDescription(eventEntity.getDescription());
        event.setBeginTimestamp(eventEntity.getBeginTime().getEpochSecond());
        event.setEndTimestamp(eventEntity.getEndTime().getEpochSecond());
        return event;
    }


    public static EventEntity toEntity(Event eventRequest) {
        EventEntity entity = new EventEntity();
        entity.setId(eventRequest.getId());
        entity.setName(eventRequest.getName());
        entity.setBeginTime(Instant.ofEpochSecond(eventRequest.getBeginTimestamp()));
        entity.setEndTime(Instant.ofEpochSecond(eventRequest.getEndTimestamp()));
        entity.setDescription(eventRequest.getDescription());
        return entity;
    }


}
