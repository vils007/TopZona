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
@Table(name = "events")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EventEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    UUID id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    EventName eventName;

    @Column
    UUID prisonerId;

    @Column
    Integer cellId;

    @Column
    UUID guardId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    ResultType result;

}
