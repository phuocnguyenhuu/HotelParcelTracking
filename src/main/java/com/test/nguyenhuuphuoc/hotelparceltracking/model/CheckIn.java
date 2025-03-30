package com.test.nguyenhuuphuoc.hotelparceltracking.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "check_ins")

@Schema(description = "Check-in information")
public class CheckIn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier")
    private Long id;

    @Schema(description = "Name of the guest")
    private String guestName;

    @Column(nullable = false)
    @Schema(description = "Check in date and time")
    private LocalDateTime checkInDate;

    @Schema(description = "Check out date and time")
    private LocalDateTime checkOutDate;

    public CheckIn(){
        this.checkInDate = LocalDateTime.now();
        this.checkOutDate = null;
        this.guestName = "";
    }

    public CheckIn(String guestName) {
        this.guestName = guestName;
        this.checkInDate = LocalDateTime.now();
        this.checkOutDate = null;

    }

    public LocalDateTime setCheckOutDate(LocalDateTime checkOutDate) {
        return this.checkOutDate = checkOutDate;
    }

    public LocalDateTime getCheckOutDate() {
        return checkOutDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public LocalDateTime getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDateTime checkInDate) {
        this.checkInDate = checkInDate;
    }
}