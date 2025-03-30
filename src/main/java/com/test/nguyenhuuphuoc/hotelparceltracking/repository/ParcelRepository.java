package com.test.nguyenhuuphuoc.hotelparceltracking.repository;

import com.test.nguyenhuuphuoc.hotelparceltracking.model.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParcelRepository extends JpaRepository<Parcel, Long> {
    List<Parcel> findByCheckInId(Long checkInId);
}