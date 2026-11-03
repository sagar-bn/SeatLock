# SeatLock

A full-stack movie ticket booking platform built with **React** and **Java Spring Boot**. The project focuses on reliable seat reservations, payment workflows, concurrency control, and practical system design.

## Project goals

- Allow customers to register, sign in, and manage their profiles.
- Browse movies, venues, screens, and showtimes.
- View seat layouts and temporarily reserve available seats.
- Complete payment and confirm bookings.
- Automatically release seats when a reservation expires or payment fails.
- Provide administration features for managing movies, venues, screens, seats, and shows.

## Technology stack

| Area | Technology |
|---|---|
| Frontend | React, Vite |
| Backend | Java 21, Spring Boot |
| Security | Spring Security, JWT |
| Persistence | Spring Data JPA, Hibernate |
| Database | MySQL 8 |
| Caching and temporary locks | Redis |
| Event messaging | Apache Kafka |
| Testing | JUnit 5, Mockito |
| API documentation | OpenAPI / Swagger |
| Deployment | Docker, AWS |

We will introduce Redis, Kafka, and distributed deployment after the core application works as a modular monolith.

## Core engineering challenges

- Preventing the same seat from being booked twice for one show.
- Managing temporary seat holds with expiration.
- Keeping booking and payment state consistent.
- Handling concurrent booking requests and duplicate payment callbacks.
- Testing race conditions and failure scenarios.

## Repository structure

```text
SeatLock/
├── backend/          # Spring Boot application (planned)
├── frontend/         # React application (planned)
├── docs/             # Requirements, diagrams, design and implementation notes
├── .gitignore
└── README.md
```

## Documentation

Project documentation is maintained in [docs/](docs/README.md). Each completed design or implementation step will be documented before we move to the next step.

## Project status

**Current stage:** Requirement analysis and system design.

See the documentation index for completed and upcoming design work.

## License

This project is licensed under the MIT License. See [LICENSE](LICENSE) when added.
