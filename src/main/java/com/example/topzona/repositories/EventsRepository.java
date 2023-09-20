package com.example.topzona.repositories;

import com.example.topzona.entities.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EventsRepository extends JpaRepository<EventEntity, UUID> {
}
