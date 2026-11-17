
package com.seatlock.Backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "seats")
public class Seat {

    // Primary key: uniquely identifies each seat.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "seat")
    private List<ShowSeat> showSeats = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "screen_id",nullable = false)
    private Screen screen;
    // Seat number, for example A1, A2, B1.
    @Column(nullable = false, length = 10)
    private String seatNumber;

    // Seat category: REGULAR, PREMIUM, RECLINER.
    @Column(nullable = false, length = 30)
    private String seatType;

    // Row identifier: A, B, C, etc.
    @Column(nullable = false, length = 5)
    private String rowLabel;

    // Position of the seat within its row.
    @Column(nullable = false)
    private Integer seatPosition;

    // Automatically stores when the seat record is created.
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // No-argument constructor required by JPA.
    public Seat() {
    }

    // Runs automatically before inserting a new record.
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    // Getters and setters.
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public String getRowLabel() {
        return rowLabel;
    }

    public void setRowLabel(String rowLabel) {
        this.rowLabel = rowLabel;
    }

    public Integer getSeatPosition() {
        return seatPosition;
    }

    public void setSeatPosition(Integer seatPosition) {
        this.seatPosition = seatPosition;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }



    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public List<ShowSeat> getShowSeats() {
        return showSeats;
    }

    public void setShowSeats(List<ShowSeat> showSeats) {
        this.showSeats = showSeats;
    }
}
