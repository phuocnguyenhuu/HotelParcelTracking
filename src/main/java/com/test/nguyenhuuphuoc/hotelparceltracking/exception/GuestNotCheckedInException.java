package com.test.nguyenhuuphuoc.hotelparceltracking.exception;

public class GuestNotCheckedInException extends RuntimeException {
    public GuestNotCheckedInException(String guestName) {
        super("Guest '" + guestName + "' is not checked in. Cannot perform operation");
    }

    public GuestNotCheckedInException(String guestName, Throwable cause) {
        super("Guest '" + guestName + "' is not checked in", cause);
    }
}