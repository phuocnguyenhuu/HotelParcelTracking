package com.test.nguyenhuuphuoc.hotelparceltracking.exception;

public class CheckInAlreadyCheckedOutException extends RuntimeException {

    // Main Constructor with check-in ID
    public CheckInAlreadyCheckedOutException(Long checkInId) {
        super("Check-in with ID " + checkInId + " is already checked out");
    }

    // Optional: Constructor for dubug
    public CheckInAlreadyCheckedOutException(Long checkInId, Throwable cause) {
        super("Check-in with ID " + checkInId + " is already checked out", cause);
    }
}