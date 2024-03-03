package com.example.OSWEB1.service;

import com.example.OSWEB1.Dto.RichiesteDto;
import com.example.OSWEB1.model.Richieste;
import com.example.OSWEB1.model.Utente;

import java.util.List;

public interface RichiesteService {
    Richieste saveRichieste(Richieste richieste);
    List<Richieste> getAllRichieste();
    Richieste getRichiesteById(long id);
    Richieste updateRichieste(Richieste richieste, long id);
    void deleteRichieste(long id);

}
