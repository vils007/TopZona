package com.example.topzona.repositories;

import com.example.topzona.entities.EventEntity;
import com.example.topzona.entities.PrisonerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PrisonersRepository extends JpaRepository<PrisonerEntity, UUID> {
}
