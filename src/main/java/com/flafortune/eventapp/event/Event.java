package com.flafortune.eventapp.event;

import lombok.Data;

import java.time.Instant;

@Data
public class Event {

    private Long id;
    private String name;
    private String description;
    private Instant beginTime;
    private Instant endTime;

    public Event() {
    }

    public Event(String name, String description, Instant beginTime, Instant endTime) {
        this.name = name;
        this.description = description;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

}
