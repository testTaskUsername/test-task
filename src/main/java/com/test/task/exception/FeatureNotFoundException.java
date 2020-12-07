package com.test.task.exception;

public class FeatureNotFoundException extends RuntimeException {

    public FeatureNotFoundException(final String message) {
        super(message);
    }
}
