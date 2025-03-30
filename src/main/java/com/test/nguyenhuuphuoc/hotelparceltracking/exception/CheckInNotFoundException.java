package com.test.nguyenhuuphuoc.hotelparceltracking.exception;

public class CheckInNotFoundException extends RuntimeException {
    public CheckInNotFoundException(Long checkInId) {
        super("Check-in record not found with ID: " + checkInId);
    }

    public CheckInNotFoundException(Long checkInId, Throwable cause) {
        super("Check-in record not found with ID: " + checkInId, cause);
    }
}