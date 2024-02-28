package com.example.OSWEB1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.OSWEB1.model.Utente;

@Repository
public interface UtenteRepository extends JpaRepository<Utente,Long> {

}
