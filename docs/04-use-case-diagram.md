# 4. Customer Use Case – Movie Booking

**Status:** Initial flow draft. Actor-level UML use-case diagram and admin use cases will be expanded during the design review.

## Actors

- **Customer:** Registers or logs in, discovers movies, chooses a venue and show, selects seats, pays, and manages bookings/profile.
- **Admin:** Manages movies, venues, screens, seat layouts, shows, and booking reports.
- **Payment gateway:** Processes a payment request and reports its outcome.

## Customer booking journey

```mermaid
flowchart TD
    A([Start]) --> B{Registered?}
    B -->|No| C[Register account]
    C --> D{Registration valid?}
    D -->|No| C
    D -->|Yes| E[Login]
    B -->|Yes| E
    E --> F{Credentials valid?}
    F -->|No| E
    F -->|Yes| G[Home page]
    G --> H[Search or browse movies]
    H --> I[Select movie]
    I --> J[View venues]
    J --> K[Select venue]
    K --> L[View showtimes]
    L --> M[Select show]
    M --> N[View seat layout]
    N --> O[Select seats]
    O --> P{Seats available?}
    P -->|No| N
    P -->|Yes| Q[Request temporary seat hold]
    Q --> R{Hold acquired?}
    R -->|No| N
    R -->|Yes| S[Start hold countdown]
    S --> T[Proceed to payment]
    T --> U{Payment outcome?}
    U -->|Success before expiry| V[Validate hold and confirm booking]
    V --> W[Mark seats booked]
    W --> X[Show booking confirmation]
    X --> Y([End])
    U -->|Failure| Z[Release held seats]
    U -->|Hold expires| Z
    Z --> AA[Show payment/hold failure]
    AA --> N
```

## Key alternate flows

1. Invalid registration: show validation errors and allow correction.
2. Invalid login: show a safe authentication error and allow retry.
3. Seat becomes unavailable before hold acquisition: refresh seat availability and ask the customer to choose again.
4. Payment fails: release the hold and show the failure result.
5. Hold expires during checkout: do not confirm the booking; release the seats.
6. Payment result arrives late: reconcile the payment result safely; never confirm a seat that has already been reallocated.

## Important clarification

The seat hold is acquired by the backend as one atomic operation for the selected seats. A frontend countdown is only a display; the backend's hold expiry is authoritative.
