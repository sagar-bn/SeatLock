
package com.seatlock.Backend.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "booking_seats")
public class BookingSeat {

    // Unique identifier for each booking-seat record.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


// BookingSeat.java - owning side

    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;



// BookingSeat.java - owning side

    @ManyToOne
    @JoinColumn(name = "show_seat_id", nullable = false)
    private ShowSeat showSeat;

    // Price paid for this particular seat.
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    // When this booking-seat record was created.
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // No-argument constructor required by JPA.
    public BookingSeat() {
    }

    // Automatically runs before inserting a record.
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ShowSeat getShowSeat() {
        return showSeat;
    }

    public void setShowSeat(ShowSeat showSeat) {
        this.showSeat = showSeat;
    }
}
