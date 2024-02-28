package com.example.OSWEB1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table
@AllArgsConstructor
public class Utente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idUtente;
	private String userName;
	private String Password;


}
