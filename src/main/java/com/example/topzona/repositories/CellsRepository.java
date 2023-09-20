package com.example.topzona.repositories;

import com.example.topzona.entities.CellEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CellsRepository extends JpaRepository<CellEntity, Integer> {
}
