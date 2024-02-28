package com.example.OSWEB1.controller;

import com.example.OSWEB1.Dto.RichiesteDto;
import com.example.OSWEB1.model.Richieste;
import com.example.OSWEB1.model.Utente;
import com.example.OSWEB1.service.RichiesteService;
import com.example.OSWEB1.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@RestController
@RequestMapping("/richieste")
public class RichiesteController {

    @Autowired
     private RichiesteService richiesteService;

    public RichiesteController(RichiesteService richiesteService) {
        super();
        this.richiesteService = richiesteService;
    }
    @PostMapping
    public ResponseEntity<Richieste> saveRichieste(@RequestBody RichiesteDto richiesteDto){

        return new ResponseEntity<Richieste>(richiesteService.saveRichieste(richiesteDto), HttpStatus.CREATED);
    }
    @GetMapping
    public List<Richieste> getAll(){
        return richiesteService.getAllRichieste();

    }
}
