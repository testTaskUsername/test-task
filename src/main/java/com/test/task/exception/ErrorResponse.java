package com.test.task.exception;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class ErrorResponse {

    String message;
    List<String> details;
}
