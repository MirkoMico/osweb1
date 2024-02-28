package com.example.OSWEB1.service.impl;

import com.example.OSWEB1.model.StatoApprovazione;
import com.example.OSWEB1.repository.StatoApprovazioneRepository;
import com.example.OSWEB1.repository.StatoRepository;
import com.example.OSWEB1.service.StatoApprovazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatoAppServiceImpl implements StatoApprovazioneService {

    @Autowired
    StatoApprovazioneRepository statoApprovazioneRepository;
    @Override
    public StatoApprovazione saveStatoApp(StatoApprovazione statoApprovazione) {
        return statoApprovazioneRepository.save(statoApprovazione) ;
    }
}
