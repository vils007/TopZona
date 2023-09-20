package com.example.topzona.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.builder.EqualsExclude;
import org.apache.commons.lang3.builder.HashCodeExclude;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cells")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CellEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    int id;

    @EqualsExclude
    @HashCodeExclude
    @Column(nullable = false)
    int capacity;

    @EqualsExclude
    @HashCodeExclude
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    CellsType type;
}
