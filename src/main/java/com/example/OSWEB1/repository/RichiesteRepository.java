package com.example.OSWEB1.repository;

import com.example.OSWEB1.model.Richieste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RichiesteRepository extends JpaRepository<Richieste, Long> {
}
