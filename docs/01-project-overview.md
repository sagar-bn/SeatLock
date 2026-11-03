# 1. SeatLock – Project Overview

## 1.1 Problem statement

SeatLock is a movie ticket booking platform where customers discover movies, choose a venue and showtime, select seats, temporarily hold those seats, and complete payment to confirm a booking.

The system must prevent the same seat for the same show from being confirmed for more than one customer.

## 1.2 Goals

- Provide customer registration, login, and profile management.
- Allow customers to browse and search movies.
- Display venues and showtimes for a selected movie.
- Display the seat layout and current seat availability for a show.
- Temporarily hold selected seats for a limited period.
- Confirm bookings only after successful payment.
- Release held seats when payment fails or the hold expires.
- Provide an admin workflow for managing movies, venues, screens, seats, and shows.

## 1.3 User roles

### Customer
- Register and log in.
- Browse and search movies.
- Select a venue and showtime.
- View and select seats.
- Complete payment and view booking confirmation.
- View booking history.
- Manage personal details and profile picture.

### Admin
- Manage movies.
- Manage venues, screens, and seat layouts.
- Schedule shows.
- View bookings and basic analytics.

### Payment gateway
- Receive payment requests.
- Return payment success or failure.
- Send payment status callbacks.

## 1.4 Initial technology stack

- Frontend: React with Vite.
- Backend: Java 21 and Spring Boot.
- Security: Spring Security and JWT.
- Persistence: Spring Data JPA and Hibernate.
- Database: MySQL 8.
- Caching and temporary coordination: Redis.
- Messaging: Apache Kafka.
- Testing: JUnit 5 and Mockito.
- API documentation: OpenAPI / Swagger.
- Deployment: Docker and AWS.

## 1.5 Architecture approach

Start with a modular monolith so the core domain and booking workflow remain easy to develop and test. Introduce Redis, Kafka, and multi-instance deployment incrementally when the design reaches the relevant scaling and reliability requirements.

## 1.6 Core booking invariant

For a given show, a physical seat can have at most one active confirmed booking. Temporary holds must expire, and booking confirmation must validate the hold and payment outcome safely.

## 1.7 Current status

Requirement analysis and system design. Detailed functional and non-functional requirements, use cases, booking flow, ER design, and architecture will be maintained in separate documents as they are finalized.
