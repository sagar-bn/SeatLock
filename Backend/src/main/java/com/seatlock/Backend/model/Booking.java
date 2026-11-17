
package com.seatlock.Backend.model;

import com.seatlock.Backend.model.Show;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bookings")
public class Booking {

    // Unique identifier for each booking.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id",nullable = false)
    private User user;

// Booking.java - owning side

    @ManyToOne
    @JoinColumn(name = "show_id", nullable = false)
    private com.seatlock.Backend.model.Show show;

// Booking.java - inverse side

    @OneToMany(mappedBy = "booking")
    private List<BookingSeat> bookingSeats = new ArrayList<>();


// Booking.java - inverse side

    @OneToMany(mappedBy = "booking")
    private List<Payment> payments = new ArrayList<>();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // Unique reference shared with the customer.
    @Column(nullable = false, unique = true, length = 50)
    private String bookingReference;

    // Total price of all seats in this booking.
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal totalAmount;

    // Current booking status.
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private BookingStatus status;

    // When the booking was created.
    @Column(nullable = false)
    private LocalDateTime bookedAt;

    // Record creation timestamp.
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // Possible booking statuses.
    public enum BookingStatus {
        PENDING,
        CONFIRMED,
        CANCELLED,
        EXPIRED
    }

    // JPA requires a no-argument constructor.
    public Booking() {
    }

    // Automatically runs before inserting a new booking.
    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();

        createdAt = now;
        bookedAt = now;

        if (status == null) {
            status = BookingStatus.PENDING;
        }
    }

    // Getters and setters.
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookingReference() {
        return bookingReference;
    }

    public void setBookingReference(String bookingReference) {
        this.bookingReference = bookingReference;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public LocalDateTime getBookedAt() {
        return bookedAt;
    }

    public void setBookedAt(LocalDateTime bookedAt) {
        this.bookedAt = bookedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<BookingSeat> getBookingSeats() {
        return bookingSeats;
    }

    public void setBookingSeats(List<BookingSeat> bookingSeats) {
        this.bookingSeats = bookingSeats;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}
