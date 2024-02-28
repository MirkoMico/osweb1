package com.example.OSWEB1.controller;

import com.example.OSWEB1.model.Richieste;
import com.example.OSWEB1.model.Stato;
import com.example.OSWEB1.service.StatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stato")
public class StatoController {
    @Autowired
    private StatoService statoService;

    @PostMapping
    public ResponseEntity<Stato> saveStato(@RequestBody Stato stato){
        return new ResponseEntity<Stato>(statoService.saveStato(stato), HttpStatus.CREATED);
    }
}
