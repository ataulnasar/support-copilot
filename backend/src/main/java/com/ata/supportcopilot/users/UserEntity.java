package com.ata.supportcopilot.users;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "users")
public record UserEntity(

        @Id
        @GeneratedValue
        @Column(nullable = false, updatable = false)
        UUID id,

        @Column(nullable = false, unique = true, length = 255)
        String email,

        @Column(name = "password_hash", nullable = false)
        String passwordHash,

        @Enumerated(EnumType.STRING)
        @Column(nullable = false, length = 50)
        Role role
) {
}
