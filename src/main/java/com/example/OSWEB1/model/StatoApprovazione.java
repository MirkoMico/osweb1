package com.example.OSWEB1.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class StatoApprovazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idStatoApp;
    private String nameStatoApprovazione;

}
