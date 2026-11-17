
package com.seatlock.Backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name = "show_seats",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"show_id", "seat_id"}
                )
        }
)
public class ShowSeat {

    // Unique identifier for each show-seat record.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


// ShowSeat.java - inverse side

    @OneToMany(mappedBy = "showSeat")
    private List<BookingSeat> bookingSeats = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "seat_id", nullable = false)
    private Seat seat;

    @ManyToOne
    @JoinColumn(name = "show_id", nullable = false)
    private Show show;
    // Current availability of this seat for a particular show.
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private SeatStatus status;

    // Time until which the seat remains temporarily locked.
    private LocalDateTime holdExpiresAt;

    // Record creation timestamp.
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // Last modification timestamp.
    private LocalDateTime updatedAt;

    // Possible seat availability states.
    public enum SeatStatus {
        AVAILABLE,
        HELD,
        BOOKED
    }

    // No-argument constructor required by JPA.
    public ShowSeat() {
    }

    // Runs before inserting a new record.
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();

        if (status == null) {
            status = SeatStatus.AVAILABLE;
        }
    }

    // Runs before updating an existing record.
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }

    public LocalDateTime getHoldExpiresAt() {
        return holdExpiresAt;
    }

    public void setHoldExpiresAt(LocalDateTime holdExpiresAt) {
        this.holdExpiresAt = holdExpiresAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public List<BookingSeat> getBookingSeats() {
        return bookingSeats;
    }

    public void setBookingSeats(List<BookingSeat> bookingSeats) {
        this.bookingSeats = bookingSeats;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
}


