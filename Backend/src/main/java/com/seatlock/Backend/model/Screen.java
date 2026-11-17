package com.seatlock.Backend.model;

import com.seatlock.Backend.model.Show;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="screens")
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "theatre_id",nullable = false)
    private Theatre theatre;

    @OneToMany(mappedBy = "screen")
    private List<Seat> seats = new ArrayList<>();

    @OneToMany(mappedBy = "screen")
    private List<Show> shows= new ArrayList<>();

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String screenType;

    @Column(nullable = false)
    private Integer totalSeats;


    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
     public Screen(){

    }

    @PrePersist
    protected void onCreate(){
         createdAt= LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public Integer getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(Integer totalSeats) {
        this.totalSeats = totalSeats;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }

}
