package com.example.OSWEB1.repository;

import com.example.OSWEB1.model.Stato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatoRepository extends JpaRepository<Stato,Integer> {
}
