package com.example.OSWEB1.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Stato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idStato;
    private String nameStato;
}
