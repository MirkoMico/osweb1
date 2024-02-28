package com.example.OSWEB1.service;

import java.util.List;

import com.example.OSWEB1.model.Utente;

public interface UtenteService {
	
	Utente saveUtente(Utente utente);
	List<Utente> getAllUtenti();
	Utente getUtenteById(long id);
	Utente updateUtente(Utente utente, long id);
	void deleteUtente(long id);
}
