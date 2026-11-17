package com.seatlock.Backend.model;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "movie")
    private List<Favorite> favorite= new ArrayList<>();


    @OneToMany(mappedBy = "movie")
    private List<com.seatlock.Backend.model.Show> shows = new ArrayList<>();
    @Column(name="title",length=100,nullable = false)
    private String title;

    @Column(length=250)
    private String description;

    @Column(nullable = false)
    private Integer durationMinutes;

    private String language;

    private String genre;

    private LocalDate releasedate;

    @Column(length = 500)
    private String PosterUrl;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAT;

    public Movie() {
    }

    @PrePersist
    protected void onCreated(){
        createdAT = LocalDateTime.now();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(LocalDate releasedate) {
        this.releasedate = releasedate;
    }

    public String getPosterUrl() {
        return PosterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        PosterUrl = posterUrl;
    }

    public LocalDateTime getCreatedAT() {
        return createdAT;
    }

    public void setCreatedAT(LocalDateTime createdAT) {
        this.createdAT = createdAT;
    }

    public List<Favorite> getFavorite() {
        return favorite;
    }

    public void setFavorite(List<Favorite> favorite) {
        this.favorite = favorite;
    }

    public List<com.seatlock.Backend.model.Show> getShows() {
        return shows;
    }

    public void setShows(List<com.seatlock.Backend.model.Show> shows) {
        this.shows = shows;
    }


}
