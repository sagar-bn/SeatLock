package com.seatlock.Backend.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "user")
    private List<Booking> booking = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Favorite> favorite = new ArrayList<>();



    @Column(nullable=false ,length =100)
    private String firstName;

    @Column(nullable= false,length =100)
    private String lastName;

    @Column(nullable= false,unique = true,length =150)
    private String email;

    @Column(nullable=false)
    private String password;
    // User phone number
    @Column(length = 15)
    private String phoneNumber;

    // URL of the user's profile picture
    private String profilePictureUrl;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,length = 20)
    private Role role;

    public enum Role{
        CUSTOMER,
        ADMIN
    }
    public User(){

    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();

        if (role == null) {
            role = Role.CUSTOMER;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Booking> getBooking() {
        return booking;
    }

    public void setBooking(List<Booking> booking) {
        this.booking = booking;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Favorite> getFavorite() {
        return favorite;
    }

    public void setFavorite(List<Favorite> favorite) {
        this.favorite = favorite;
    }
}