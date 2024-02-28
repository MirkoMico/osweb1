package com.example.OSWEB1.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.OSWEB1.model.Utente;
import com.example.OSWEB1.service.UtenteService;

@RestController
@RequestMapping("/utente")
public class UtenteController {

	
	private UtenteService utenteService;

	public UtenteController(UtenteService utenteService) {
		super();
		this.utenteService = utenteService;
	}

	@PostMapping
	public ResponseEntity<Utente> saveUtente(@RequestBody Utente utente){
		return new ResponseEntity<Utente>(utenteService.saveUtente(utente), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Utente> getAllUtenti(){
		return utenteService.getAllUtenti();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Utente> getUtenteById(@PathVariable ("id") long employeeId){
		return new ResponseEntity<Utente>(utenteService.getUtenteById(employeeId),HttpStatus.OK);
		
	}
	@PutMapping("{id}")
	public ResponseEntity<Utente> updateUtente(@PathVariable("id") long id,
												 @RequestBody Utente utente){
		return new ResponseEntity<Utente>(utenteService.updateUtente(utente, id), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUtente(@PathVariable("id")long id){
		utenteService.deleteUtente(id);
		return new ResponseEntity("Employee deleted successfully",HttpStatus.OK);
		
	}

}
