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
@Table(name = "requisites")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RequisitesEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id")
    UUID id;

    @Column
    String state;

    @Column
    String region;

    @Column
    String city;

    @Column
    String address;

    @Column(name = "name", nullable = false)
    String name;
}
