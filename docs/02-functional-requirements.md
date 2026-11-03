# 2. Functional Requirements

**Status:** Draft based on the requirements agreed during project planning.

## 2.1 Customer account and profile
- FR-01: A visitor can register an account.
- FR-02: A registered customer can log in and log out.
- FR-03: An authenticated customer can view and update personal details.
- FR-04: A customer can upload, update, and remove a profile picture.
- FR-05: A customer can change their password securely.

## 2.2 Movie discovery
- FR-06: A customer can browse the movie catalogue on the home page.
- FR-07: A customer can search for movies.
- FR-08: A customer can view movie details.
- FR-09: A customer can view venues showing a selected movie.
- FR-10: A customer can view available showtimes for a selected venue.

## 2.3 Seat selection and booking
- FR-11: A customer can view the seat layout and availability for a show.
- FR-12: A customer can select one or more available seats.
- FR-13: The system temporarily holds selected seats for a configured period.
- FR-14: The system prevents another customer from holding or booking an actively held seat for the same show.
- FR-15: A customer can initiate payment for a booking.
- FR-16: The system confirms a booking only after successful payment and valid seat-hold verification.
- FR-17: The system releases held seats when payment fails or the hold expires.
- FR-18: A customer can view booking confirmation and booking history.
- FR-19: A customer can cancel a booking when the cancellation policy allows it.

## 2.4 Administration
- FR-20: An admin can create and manage movies.
- FR-21: An admin can create and manage venues and screens.
- FR-22: An admin can configure physical seat layouts.
- FR-23: An admin can schedule shows and configure pricing.
- FR-24: An admin can view bookings and basic analytics.

## 2.5 Payment integration
- FR-25: The system can initiate a payment attempt.
- FR-26: The system can process payment success and failure results.
- FR-27: The system handles repeated payment callbacks idempotently.

## 2.6 Scope note

The first version will use a simulated payment gateway. A real payment provider may be integrated later without changing the core booking rules.

## 2.7 Review notes

Priorities, validation rules, cancellation policy, and detailed acceptance criteria will be finalized before implementation.
