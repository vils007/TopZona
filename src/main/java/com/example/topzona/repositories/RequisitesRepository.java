package com.example.topzona.repositories;

import com.example.topzona.entities.RequisitesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Repository
public interface RequisitesRepository extends JpaRepository<RequisitesEntity, UUID> {

    Optional<RequisitesEntity> findByName(String name);

    Stream<RequisitesEntity> streamAllBy();

    Stream<RequisitesEntity> streamAllByNameStartsWithIgnoreCase(String prefixName);
}
