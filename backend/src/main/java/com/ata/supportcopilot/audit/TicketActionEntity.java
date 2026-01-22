package com.ata.supportcopilot.audit;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "ticket_actions")
public record TicketActionEntity(

        @Id
        @GeneratedValue
        UUID id,

        @Column(nullable = false)
        UUID ticketId,

        @Column(nullable = false)
        UUID actorUserId,

        @Enumerated(EnumType.STRING)
        @Column(nullable = false, length = 50)
        TicketActionType actionType,

        @Column(columnDefinition = "jsonb")
        String metadata,

        @Column(nullable = false, updatable = false)
        Instant createdAt
) {
    public static TicketActionEntity create(
            UUID ticketId,
            UUID actorUserId,
            TicketActionType actionType,
            String metadata
    ) {
        return new TicketActionEntity(
                null,
                ticketId,
                actorUserId,
                actionType,
                metadata,
                Instant.now()
        );
    }
}
