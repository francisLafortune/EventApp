package com.flafortune.eventapp.event;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.Instant;

public class EventValidator implements Validator {

    @Override
    public boolean supports(Class clazz) {
        return Event.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Event event = (Event) target;

        String name = event.getName();
        if (name == null || name.isEmpty() || name.isBlank()) {
            errors.rejectValue("name", "missingvalue", "Name is required.");
        } else if (name.length() > 32) {
            errors.rejectValue("name", "toolongvalue", "Name is longer than 32 characters.");
        }

        Instant beginTime = event.getBeginTime();
        if (beginTime == null) {
            errors.rejectValue("beginTime", "missingvalue", "BeginTime is required.");
        }

        Instant endTime = event.getEndTime();
        if (endTime == null) {
            errors.rejectValue("endTime", "missingvalue", "EndTime is required.");
        }

        if (beginTime != null && endTime != null && endTime.isBefore(beginTime)) {
            errors.rejectValue("beginTime", "invaliddate", "BeginTime is after endTime.");
            errors.rejectValue("endTime", "invaliddate", "EndTime is before beginTime.");
        }

    }

}
