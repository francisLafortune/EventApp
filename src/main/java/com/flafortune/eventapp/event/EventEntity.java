package com.flafortune.eventapp.event;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Entity
@Data
@Table(schema = "event_app", name = "events")
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 32)
    private String name;

    @Column
    private String description;

    @Column
    private Instant beginTime;

    @Column
    private Instant endTime;
}
