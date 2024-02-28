package com.example.OSWEB1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OSWEB1.exception.ResourceNotFoundException;
import com.example.OSWEB1.model.Utente;
import com.example.OSWEB1.repository.UtenteRepository;
import com.example.OSWEB1.service.UtenteService;

@Service
public class UtenteServiceImpl implements UtenteService {

	@Autowired
	private UtenteRepository utenteRepository;

	public UtenteServiceImpl(UtenteRepository utenteRepository) {
		super();
		this.utenteRepository = utenteRepository;
	}



	@Override
	public Utente saveUtente(Utente utente) {
		return utenteRepository.save(utente);
	}



	@Override
	public List<Utente> getAllUtenti() {
		// TODO Auto-generated method stub
		return utenteRepository.findAll();
	}



	@Override
	public Utente getUtenteById(long id) {
//		Optional<Employee> employee = employeeRepository.findById(id);
//		if(employee.isPresent()) {
//			return employee.get();
//		} else {
//			
//			throw new ResourceNotFoundException("Employee","id",id);
//		}
		return utenteRepository.findById(id).orElseThrow(()-> new
				ResourceNotFoundException("Utente", "id", id));
	}



	@Override
	public Utente updateUtente(Utente utente, long id) {
		Utente existingUtente = utenteRepository.findById(id)
				.orElseThrow( ()-> new ResourceNotFoundException("Utente","Id",id)) ;
		existingUtente.setIdUtente(utente.getIdUtente());
		existingUtente.setUserName(utente.getUserName());
		existingUtente.setPassword(utente.getPassword());
		
		utenteRepository.save(existingUtente);
		return existingUtente;
	}



	@Override
	public void deleteUtente(long id) {
		
		utenteRepository.findById(id).orElseThrow(
				()->(new ResourceNotFoundException("Utente", "Id", id)));
		utenteRepository.deleteById(id);
		
	}

}
