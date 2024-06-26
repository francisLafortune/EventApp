TRUNCATE TABLE event_app.events RESTART IDENTITY;

INSERT INTO event_app.events ("name", description, begin_time, end_time)
VALUES ('event 1', 'description 1', '2024-01-01 10:00:00', '2024-01-01 12:00:00'),
       ('event 2', 'description 2', '2024-01-02 10:00:00', '2024-01-02 12:00:00');
