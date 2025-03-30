package com.test.nguyenhuuphuoc.hotelparceltracking.controller;

import com.test.nguyenhuuphuoc.hotelparceltracking.dto.ParcelRequest;
import com.test.nguyenhuuphuoc.hotelparceltracking.model.Parcel;
import com.test.nguyenhuuphuoc.hotelparceltracking.service.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/parcels")
@Tag(name = "Parcel Controller", description = "APIs for managing parcels")
public class ParcelController {
    private final ParcelService parcelService;

    @Autowired
    public ParcelController(ParcelService parcelService) {
        this.parcelService = parcelService;
    }

    @Operation(summary = "Accept a parcel",
            description = "Records a new parcel for a checked-in guest")
    @PostMapping
    public ResponseEntity<Parcel> acceptParcel(@RequestBody ParcelRequest request) {
        Parcel parcel = parcelService.acceptParcel(request.guestName(), request.description());
        return ResponseEntity.ok(parcel);
    }

    @Operation(summary = "Get parcels for check-in",
            description = "Retrieves all parcels associated with a check-in")
    @GetMapping("/checkins/{checkInId}/parcels")
    public ResponseEntity<List<Parcel>> getParcelsForCheckIn(@PathVariable Long checkInId) {
        List<Parcel> parcels = parcelService.getParcelsForCheckIn(checkInId);
        return ResponseEntity.ok(parcels);
    }
}