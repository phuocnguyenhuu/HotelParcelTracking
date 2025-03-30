package com.test.nguyenhuuphuoc.hotelparceltracking.repository;

import com.test.nguyenhuuphuoc.hotelparceltracking.model.CheckIn;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CheckInRepository extends JpaRepository<CheckIn, Long> {
    Optional<CheckIn> findByGuestNameAndCheckOutDateIsNull(String guestName);
    boolean existsByGuestNameAndCheckOutDateIsNull(String guestName);
}
