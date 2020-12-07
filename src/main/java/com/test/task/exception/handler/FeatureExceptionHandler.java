package com.test.task.exception.handler;

import com.test.task.exception.ErrorResponse;
import com.test.task.exception.FeatureNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static java.util.Collections.singletonList;

@ControllerAdvice
public class FeatureExceptionHandler extends ResponseEntityExceptionHandler {

    public static final String FEATURE_NOT_FOUND_EXCEPTION = "FeatureNotFoundException";

    @ExceptionHandler(FeatureNotFoundException.class)
    public ResponseEntity<Object> handleFeatureNotFoundException(final FeatureNotFoundException exception) {
        final ErrorResponse errorResponse = ErrorResponse.builder()
                .message(FEATURE_NOT_FOUND_EXCEPTION)
                .details(singletonList(exception.getLocalizedMessage()))
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
