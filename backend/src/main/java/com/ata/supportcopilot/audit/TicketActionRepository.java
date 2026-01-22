package com.ata.supportcopilot.audit;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TicketActionRepository extends JpaRepository<TicketActionEntity, UUID> {
    List<TicketActionEntity> findByTicketIdOrderByCreatedAtAsc(UUID ticketId);
}
