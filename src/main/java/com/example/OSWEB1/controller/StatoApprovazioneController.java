package com.example.OSWEB1.controller;

import com.example.OSWEB1.model.Stato;
import com.example.OSWEB1.model.StatoApprovazione;
import com.example.OSWEB1.service.StatoApprovazioneService;
import com.example.OSWEB1.service.StatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stato_approvazione")
public class StatoApprovazioneController {
    @Autowired
    private StatoApprovazioneService statoApprovazioneService;

    @PostMapping
    public ResponseEntity<StatoApprovazione> saveStatoApp(@RequestBody StatoApprovazione statoApprovazione){
        return new ResponseEntity<StatoApprovazione>(
                statoApprovazioneService.saveStatoApp(statoApprovazione), HttpStatus.CREATED);
    }

}
