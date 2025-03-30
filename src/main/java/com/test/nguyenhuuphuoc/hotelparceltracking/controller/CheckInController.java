package com.test.nguyenhuuphuoc.hotelparceltracking.controller;

import com.test.nguyenhuuphuoc.hotelparceltracking.dto.CheckInRequest;
import com.test.nguyenhuuphuoc.hotelparceltracking.exception.GuestNotCheckedInException;
import com.test.nguyenhuuphuoc.hotelparceltracking.model.CheckIn;
import com.test.nguyenhuuphuoc.hotelparceltracking.service.CheckInService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/checkin")
@Tag(name = "Check-in Controller", description = "APIs for managing guest check-ins")
public class CheckInController {
    private final CheckInService checkInService;

    @Autowired
    public CheckInController(CheckInService checkInService) {
        this.checkInService = checkInService;
    }

    @Operation(summary = "Check in a guest",
            description = "Creates a new check-in record for a guest")
    @PostMapping
    public ResponseEntity<CheckIn> checkInGuest(@RequestBody CheckInRequest request) {
        CheckIn checkIn = checkInService.checkInGuest(request.guestName());
        return ResponseEntity.ok(checkIn);
    }

    @Operation(summary = "Check out a guest",
            description = "Updates the check-in record to checked-out status")
    @PutMapping("/{id}/checkout")
    public ResponseEntity<CheckIn> checkOutGuest(@PathVariable Long id) {
        CheckIn checkIn = checkInService.checkOutGuest(id);
        return ResponseEntity.ok(checkIn);
    }

    @GetMapping("/active")
    @Operation(summary = "Find active check-in by guest name")
    public ResponseEntity<CheckIn> findActiveCheckIn(@RequestParam String guestName) {
        CheckIn checkIn = checkInService.findActiveCheckIn(guestName)
                .orElseThrow(() -> new GuestNotCheckedInException(guestName));
        return ResponseEntity.ok(checkIn);
    }
}
