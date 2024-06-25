package com.flafortune.eventapp.event;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class EventValidatorTest {

    private final EventValidator eventValidator = new EventValidator();

    private Event event;
    private Errors errors;

    @BeforeEach
    void setUp() {
        event = new Event(
                "My event",
                "My event description",
                Instant.parse("2024-01-01T16:00:00Z"),
                Instant.parse("2024-01-01T18:00:00Z")
        );

        errors = new BeanPropertyBindingResult(event, "event");
    }

    @AfterEach
    void tearDown() {
        event = null;
        errors = null;
    }


    @Test
    void validEventIsValid() {
        eventValidator.validate(event, errors);
        assertFalse(errors.hasErrors());
    }

    @Test
    void emptyEventCauseProperErrors() {
        eventValidator.validate(new Event(), errors);
        assertEquals(3, errors.getErrorCount());
    }

    @Test
    void nameMustNotBeNull() {
        event.setName(null);
        eventValidator.validate(event, errors);
        assertEquals(1, errors.getErrorCount());
        assertEquals("Name is required.", errors.getFieldError("name").getDefaultMessage());
    }

    @Test
    void nameMustNotBeEmpty() {
        event.setName("");
        eventValidator.validate(event, errors);
        assertEquals(1, errors.getErrorCount());
        assertEquals("Name is required.", errors.getFieldError("name").getDefaultMessage());
    }

    @Test
    void nameMustBe32CharOrShorter() {
        event.setName("Very long name, longer than 32 characters");
        eventValidator.validate(event, errors);
        assertEquals(1, errors.getErrorCount());
        assertEquals("Name is longer than 32 characters.", errors.getFieldError("name").getDefaultMessage());
    }

    @Test
    void nameMustNotBeBlank() {
        event.setName(" ");
        eventValidator.validate(event, errors);
        assertEquals(1, errors.getErrorCount());
        assertEquals("Name is required.", errors.getFieldError("name").getDefaultMessage());
    }

    @Test
    void beginTimeMustNotBeNull() {
        event.setBeginTime(null);
        eventValidator.validate(event, errors);
        assertEquals(1, errors.getErrorCount());
        assertEquals("BeginTime is required.", errors.getFieldError("beginTime").getDefaultMessage());
    }

    @Test
    void endTimeMustNotBeNull() {
        event.setEndTime(null);
        eventValidator.validate(event, errors);
        assertEquals(1, errors.getErrorCount());
        assertEquals("EndTime is required.", errors.getFieldError("endTime").getDefaultMessage());
    }

    @Test
    void endTimeMustBeEqualOrAfterBeginTime() {
        event.setEndTime(Instant.parse("2024-01-01T15:00:00Z"));
        eventValidator.validate(event, errors);
        assertEquals(2, errors.getErrorCount());
        assertEquals("BeginTime is after endTime.", errors.getFieldError("beginTime").getDefaultMessage());
        assertEquals("EndTime is before beginTime.", errors.getFieldError("endTime").getDefaultMessage());
    }

}