package com.example.topzona.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;




@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "guards")
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString(exclude = {"name", "aggression", "health"})
@EqualsAndHashCode(exclude = {"name", "aggression", "health"})
public class GuardEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    UUID id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    Integer aggression;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    HealthType health;
}
