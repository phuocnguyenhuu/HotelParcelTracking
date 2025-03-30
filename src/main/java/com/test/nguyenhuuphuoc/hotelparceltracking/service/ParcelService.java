package com.test.nguyenhuuphuoc.hotelparceltracking.service;

import com.test.nguyenhuuphuoc.hotelparceltracking.exception.GuestNotCheckedInException;
import com.test.nguyenhuuphuoc.hotelparceltracking.model.CheckIn;
import com.test.nguyenhuuphuoc.hotelparceltracking.model.Parcel;
import com.test.nguyenhuuphuoc.hotelparceltracking.repository.ParcelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ParcelService {
    @Autowired
    private CheckInService checkInService;

    @Autowired
    private ParcelRepository parcelRepository;

    public Parcel acceptParcel(String guestName, String description) {
        CheckIn checkIn = checkInService.findActiveCheckIn(guestName)
                .orElseThrow(() -> new GuestNotCheckedInException(guestName));
        Parcel parcel = new Parcel();
        parcel.setCheckIn(checkIn);
        parcel.setDescription(description);
        parcel.setReceivedTime(LocalDateTime.now());
        return parcelRepository.save(parcel);
    }

    public List<Parcel> getParcelsForCheckIn(Long checkInId) {
        return parcelRepository.findByCheckInId(checkInId);
    }
}