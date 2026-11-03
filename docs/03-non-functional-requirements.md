# 3. Non-Functional Requirements

**Status:** Draft based on the requirements agreed during project planning.

| ID | Attribute | Requirement |
|---|---|---|
| NFR-01 | Consistency | A seat for a particular show must not be confirmed in more than one booking. |
| NFR-02 | Concurrency | The system must safely handle simultaneous requests for the same seat. |
| NFR-03 | Reliability | Failed or expired booking attempts must release temporary seat holds. |
| NFR-04 | Payment integrity | Duplicate or delayed payment callbacks must not create duplicate bookings. |
| NFR-05 | Security | Authentication and authorization must protect customer and admin operations. |
| NFR-06 | Privacy | Customers may access and modify only their own profile and booking data, subject to admin permissions. |
| NFR-07 | Performance | Movie, venue, showtime, and seat-availability reads should be responsive. |
| NFR-08 | Scalability | The design should allow additional application instances and increased booking traffic. |
| NFR-09 | Maintainability | Backend modules should have clear responsibilities and testable boundaries. |
| NFR-10 | Observability | Important booking, payment, and seat-hold events should be logged and traceable. |
| NFR-11 | Recoverability | The system should recover safely from application restarts and transient infrastructure failures. |

## Measurable targets to define

Before production-oriented testing, define numeric targets for API latency, throughput, concurrent booking attempts, availability, recovery time, and retention of logs. These targets are intentionally not invented at this stage.
