# 5. Customer Booking Flow

**Status:** Initial workflow draft.

## Main flow

1. Customer registers or logs in.
2. The application opens the home page.
3. Customer searches or browses movies.
4. Customer selects a movie.
5. Application lists venues showing that movie.
6. Customer selects a venue and views showtimes.
7. Customer selects a show and views its seat layout.
8. Customer selects seats and requests a temporary hold.
9. Backend verifies availability and atomically acquires the hold.
10. If the hold succeeds, the customer proceeds to payment while the hold timer runs.
11. If payment succeeds before expiry, the backend verifies the hold and payment result, then confirms the booking.
12. If payment fails or the hold expires, the backend releases the seats.

## Seat state model (initial)

- AVAILABLE: no active hold or confirmed booking exists for this show-seat.
- HELD: a customer temporarily owns the hold until its expiry time.
- BOOKED: a confirmed booking owns the show-seat.

A physical seat belongs to a screen. Availability is specific to a show, so it must be represented per show rather than stored only on the physical seat record.

## Booking rules

- A seat hold is scoped to a show and a customer/booking attempt.
- The backend, not the browser timer, decides whether a hold is active.
- Hold acquisition must be atomic for all requested seats: either all requested seats are held or none are held.
- The database must enforce protection against duplicate confirmed reservations.
- Payment confirmation must be idempotent.
- Expired holds must be released even if the customer closes the browser.
- If a payment succeeds after the hold has expired and the seats have been reallocated, the system must not double-book. The payment must enter a reconciliation/refund path.

## Failure scenarios

| Scenario | Expected result |
|---|---|
| Another customer already holds a selected seat | Reject the hold request and return current availability. |
| A selected seat is already booked | Reject the hold request. |
| Payment fails | Release the active hold. |
| Hold expires before payment success | Reject booking confirmation and release the hold. |
| Browser closes during checkout | Hold expires server-side and is released. |
| Duplicate payment callback | Return the existing payment/booking outcome without duplicate effects. |
| Backend instance restarts | Persisted hold expiry data allows expired holds to be recovered. |

## Timeout policy

The initial planned hold duration is five minutes. This is a configurable product rule and will be finalized during implementation. The backend expiry timestamp is authoritative.

## Design items to resolve

- Exact booking and payment status state machines.
- Whether payment failure releases immediately or allows a controlled retry window.
- Payment callback reconciliation and refund policy.
- Database locking and uniqueness constraints.
- Redis usage and consistency with the database.
