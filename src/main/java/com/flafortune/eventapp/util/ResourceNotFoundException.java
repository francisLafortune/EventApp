package com.flafortune.eventapp.util;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super("The specified resource could not be found.");
    }
}
