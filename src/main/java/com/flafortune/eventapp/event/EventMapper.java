package com.flafortune.eventapp.event;

public class EventMapper {

    public static EventEntity toEntity(Event event) {
        EventEntity entity = new EventEntity();
        entity.setId(event.getId());
        entity.setName(event.getName());
        entity.setBeginTime(event.getBeginTime());
        entity.setEndTime(event.getEndTime());
        entity.setDescription(event.getDescription());
        return entity;
    }

    public static Event toEvent(EventEntity entity) {
        Event event = new Event();
        event.setId(entity.getId());
        event.setName(entity.getName());
        event.setBeginTime(entity.getBeginTime());
        event.setEndTime(entity.getEndTime());
        event.setDescription(entity.getDescription());
        return event;
    }

}
