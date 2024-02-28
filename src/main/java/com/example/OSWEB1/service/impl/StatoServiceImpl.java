package com.example.OSWEB1.service.impl;

import com.example.OSWEB1.model.Stato;
import com.example.OSWEB1.model.StatoApprovazione;
import com.example.OSWEB1.repository.StatoApprovazioneRepository;
import com.example.OSWEB1.repository.StatoRepository;
import com.example.OSWEB1.service.StatoService;
import com.example.OSWEB1.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatoServiceImpl implements StatoService {
    @Autowired
    private StatoRepository statoRepository;
    @Override
    public Stato saveStato(Stato stato) {
        return statoRepository.save(stato);
    }
}
