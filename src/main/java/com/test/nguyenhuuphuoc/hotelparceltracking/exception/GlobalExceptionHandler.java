package com.test.nguyenhuuphuoc.hotelparceltracking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({GuestAlreadyCheckedInException.class, GuestNotCheckedInException.class, CheckInNotFoundException.class, CheckInAlreadyCheckedOutException.class})
    public ResponseEntity<ErrorResponse> handleCustomExceptions(RuntimeException ex) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        if (ex instanceof GuestNotCheckedInException) status = HttpStatus.NOT_FOUND;
        if (ex instanceof CheckInNotFoundException) status = HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(new ErrorResponse(status.value(), ex.getMessage()));
    }
}

class ErrorResponse {
    private int status;
    private String message;

    public ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    // Getters và setters
}
