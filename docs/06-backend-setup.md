# Backend Setup

## Overview

This document records the initial backend setup for SeatLock.

## Technology choices

- **Language:** Java 21
- **Framework:** Spring Boot
- **Build tool:** Maven (Maven Wrapper)
- **Packaging:** JAR
- **Database:** MySQL 8
- **Persistence:** Spring Data JPA with Hibernate
- **Backend port:** 8081

## Project generation

The Spring Boot project was generated using [Spring Initializr](https://start.spring.io/) with these settings:

| Setting | Value |
|---|---|
| Project | Maven |
| Language | Java |
| Group | `com.seatlock` |
| Artifact | `backend` |
| Name | `SeatLock` |
| Package | `com.seatlock.backend` |
| Packaging | JAR |
| Java | 21 |

### Dependencies

- Spring Web
- Spring Data JPA
- Spring Security
- MySQL Driver
- Validation
- Lombok
- Spring Boot DevTools

JWT and Swagger/OpenAPI will be added during the relevant implementation steps.

## MySQL setup

1. Confirm that the MySQL Server service is running.
2. Create the application database:

```sql
CREATE DATABASE seatlock_db;
```

3. Configure the database connection in `src/main/resources/application.properties`.

## Application configuration

The initial development configuration uses:

```properties
# Run the backend on 8081 because port 8080 is used by Jenkins.
server.port=8081

# Connect to the local SeatLock MySQL database.
spring.datasource.url=jdbc:mysql://localhost:3306/seatlock_db
spring.datasource.username=root
spring.datasource.password=YOUR_MYSQL_PASSWORD
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Update the schema from JPA entity definitions during development.
spring.jpa.hibernate.ddl-auto=update

# Show SQL statements and format them in the console.
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

**Security note:** Replace the password placeholder locally. Never commit real database credentials. Move credentials to environment variables before sharing deployment configuration.

**Schema note:** `ddl-auto=update` is being used only for early development. A database migration tool such as Flyway should be introduced for controlled schema changes before production.

## Running the backend

From the `backend` directory on Windows:

```powershell
.\\mvnw.cmd spring-boot:run
```

The expected startup log includes messages similar to:

```text
Tomcat started on port 8081
Started BackendApplication
```

The local application address is:

- http://localhost:8081

A 404 response at the root URL is expected until a controller endpoint is created.

## Verification

- [x] Spring Boot project generated.
- [x] Maven build completed successfully.
- [x] MySQL Server service confirmed running.
- [x] `seatlock_db` database created.
- [x] Backend configured to use port 8081.
- [x] Backend started successfully with the MySQL connection configured.

## Next step

Create the backend package structure and begin implementing the first application components.
