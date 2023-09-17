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
@Table(name = "prisoners")
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString(exclude = {"name", "nicName", "type", "cell", "aggression", "health"})
@EqualsAndHashCode(exclude = {"name", "nicName", "type", "cell", "aggression", "health"})
public class PrisonerEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    UUID id;

    @Column(nullable = false)
    String name;

    @Column
    String nicName;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    PrisonerType type;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cell_id", referencedColumnName = "id")
    CellEntity cell;

    @Column(nullable = false)
    Integer aggression;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    HealthType health;

    @Column(nullable = false)
    Boolean isCooperation;
}
