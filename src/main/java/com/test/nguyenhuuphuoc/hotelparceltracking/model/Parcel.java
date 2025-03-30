package com.test.nguyenhuuphuoc.hotelparceltracking.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "parcels")
public class Parcel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private LocalDateTime receivedTime;

    @ManyToOne
    @JoinColumn(name = "check_in_id")
    private CheckIn checkIn;

    private String guestName;

    public Parcel() {}

    public Parcel(String guestName, String description) {
        this.guestName = guestName;
        this.description = description;
        this.receivedTime = LocalDateTime.now();
    }

    // Getters
    public Long getId() { return id; }
    public String getDescription() { return description; }
    public LocalDateTime getReceivedTime() { return receivedTime; }
    public CheckIn getCheckIn() { return checkIn; }
    public String getGuestName() { return guestName; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setDescription(String description) { this.description = description; }
    public void setReceivedTime(LocalDateTime receivedTime) { this.receivedTime = receivedTime; }
    public void setCheckIn(CheckIn checkIn) { this.checkIn = checkIn; }
    public void setGuestName(String guestName) { this.guestName = guestName; }
}