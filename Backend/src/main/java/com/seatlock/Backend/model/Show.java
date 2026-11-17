
package com.seatlock.Backend.model;

import com.seatlock.Backend.model.Booking;
import com.seatlock.Backend.model.Movie;
import com.seatlock.Backend.model.Screen;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shows")
public class Show {

    // Unique identifier for every show.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "screen_id", nullable = false)
    private Screen screen;
    // Date and time when the movie screening starts.
    @Column(nullable = false)
    private LocalDateTime showTime;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;


// Show.java - inverse side

    @OneToMany(mappedBy = "show")
    private List<Booking> bookings = new ArrayList<>();


    @OneToMany(mappedBy = "show")
    private List<ShowSeat> showSeats = new ArrayList<>();
    // Expected ending time of the screening.
    @Column(nullable = false)
    private LocalDateTime endTime;

    // Base ticket price. BigDecimal is preferred for money.
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal basePrice;

    // Current status of the show.
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private ShowStatus status;

    // Date and time when this show record was created.
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // Possible show statuses.
    public enum ShowStatus {
        SCHEDULED,
        CANCELLED,
        COMPLETED
    }

    // No-argument constructor required by JPA.
    public Show() {
    }

    // Automatically runs before the first database insert.
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();

        // Set the default status when none is provided.
        if (status == null) {
            status = ShowStatus.SCHEDULED;
        }
    }

    // Getters and setters.
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public ShowStatus getStatus() {
        return status;
    }

    public void setStatus(ShowStatus status) {
        this.status = status;
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

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
