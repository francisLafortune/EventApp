package com.flafortune.eventapp.event;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Event {


    private Long id;

    @NotBlank(message = "Name is required.")
    @Size(max = 32, message = "Name length must be 32 characters or less.")
    private String name;

    @NotBlank(message = "Description is required.")
    private String description;

    @NotNull(message = "Begin timestamp is required.")
    private Long beginTimestamp;

    @NotNull(message = "End timestamp is required.")
    private Long endTimestamp;

}
