package com.ata.supportcopilot.tickets;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TicketRepository extends JpaRepository<TicketEntity, UUID> {
    List<TicketEntity> findByCustomerEmailIgnoreCase(String customerEmail);
    List<TicketEntity> findByStatus(TicketStatus status);
    List<TicketEntity> findByAssigneeUserId(UUID assigneeUserId);
}
