CREATE SCHEMA IF NOT EXISTS event_app;

CREATE TABLE IF not exists event_app.events (
    id serial primary key,
    "name" varchar(32) not null,
    description text not null,
    begin_time TIMESTAMP,
    end_time TIMESTAMP
);