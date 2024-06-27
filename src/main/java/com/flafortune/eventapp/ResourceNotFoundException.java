package com.flafortune.eventapp;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super("The specified resource could not be found.");
    }
}
