package com.ata.supportcopilot.tickets;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "tickets")
public record TicketEntity(

        @Id
        @GeneratedValue
        UUID id,

        String subject,
        String body,
        String customerEmail,

        @Enumerated(EnumType.STRING)
        TicketStatus status,

        UUID assigneeUserId,

        Instant createdAt,
        Instant updatedAt
) {
    public static TicketEntity create(
            String subject,
            String body,
            String customerEmail,
            TicketStatus status,
            UUID assigneeUserId
    ) {
        Instant now = Instant.now();
        return new TicketEntity(
                null,
                subject,
                body,
                customerEmail,
                status,
                assigneeUserId,
                now,
                now
        );
    }

    public TicketEntity updateStatus(TicketStatus newStatus) {
        return new TicketEntity(
                id,
                subject,
                body,
                customerEmail,
                newStatus,
                assigneeUserId,
                createdAt,
                Instant.now()
        );
    }
}