package com.test.nguyenhuuphuoc.hotelparceltracking.service;

import com.test.nguyenhuuphuoc.hotelparceltracking.exception.CheckInAlreadyCheckedOutException;
import com.test.nguyenhuuphuoc.hotelparceltracking.exception.CheckInNotFoundException;
import com.test.nguyenhuuphuoc.hotelparceltracking.exception.GuestAlreadyCheckedInException;
import com.test.nguyenhuuphuoc.hotelparceltracking.model.CheckIn;
import com.test.nguyenhuuphuoc.hotelparceltracking.repository.CheckInRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CheckInService {
    @Autowired
    private CheckInRepository checkInRepository;

    public CheckIn checkInGuest(String guestName) {
        if (checkInRepository.existsByGuestNameAndCheckOutDateIsNull(guestName)) {
            throw new GuestAlreadyCheckedInException(guestName);
        }
        CheckIn checkIn = new CheckIn(guestName);
        return checkInRepository.save(checkIn);
    }

    public CheckIn checkOutGuest(Long checkInId) {
        CheckIn checkIn = checkInRepository.findById(checkInId)
                .orElseThrow(() -> new CheckInNotFoundException(checkInId));
        if (checkIn.getCheckOutDate() != null) {
            throw new CheckInAlreadyCheckedOutException(checkInId);
        }
        checkIn.setCheckOutDate(LocalDateTime.now());
        return checkInRepository.save(checkIn);
    }

    public Optional<CheckIn> findActiveCheckIn(String guestName) {
        return checkInRepository.findByGuestNameAndCheckOutDateIsNull(guestName);
    }
}
