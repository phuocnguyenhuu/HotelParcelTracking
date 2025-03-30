package com.test.nguyenhuuphuoc.hotelparceltracking.exception;

public class GuestAlreadyCheckedInException extends RuntimeException {
    public GuestAlreadyCheckedInException(String guestName) {
        super("Guest '" + guestName + "' is already checked in and cannot check in again");
    }

    // Optional: Thêm constructor với cause nếu cần
    public GuestAlreadyCheckedInException(String guestName, Throwable cause) {
        super("Guest '" + guestName + "' is already checked in", cause);
    }
}