package com.example.OSWEB1.service.impl;

import com.example.OSWEB1.Dto.RichiesteDto;
import com.example.OSWEB1.exception.ResourceNotFoundException;
import com.example.OSWEB1.model.Richieste;
import com.example.OSWEB1.model.Stato;
import com.example.OSWEB1.model.StatoApprovazione;
import com.example.OSWEB1.model.Utente;
import com.example.OSWEB1.repository.RichiesteRepository;
import com.example.OSWEB1.repository.StatoApprovazioneRepository;
import com.example.OSWEB1.repository.StatoRepository;
import com.example.OSWEB1.service.RichiesteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RichiesteServiceImpl implements RichiesteService {

    @Autowired
    private RichiesteRepository richiesteRepository;
    @Autowired
    private StatoRepository statoRepository;
    @Autowired
    private StatoApprovazioneRepository statoApprovazioneRepository;

    @Override
    public Richieste saveRichieste(RichiesteDto richiesteDto) {
        Optional<Stato> optionalStato= statoRepository.findById(richiesteDto.getStatoId());
        if (optionalStato.isEmpty()){
            return null;
        }
        Stato stato=optionalStato.get();
        Optional<StatoApprovazione> optionalStatoApprovazione=
                statoApprovazioneRepository.findById(richiesteDto.getStatoApprovazioneId());
        if (optionalStato.isEmpty()){
            return null;
        }
        StatoApprovazione statoApprovazione=optionalStatoApprovazione.get();


        Richieste newRichesta=new Richieste(richiesteDto.getId(),richiesteDto.getIdCommessa(),
                richiesteDto.getOggetto(),stato,richiesteDto.getDataCreazione(),
                statoApprovazione,richiesteDto.getNote(),
                richiesteDto.getCampo1(),richiesteDto.getCampo2(),richiesteDto.getCampo3(),richiesteDto.getCampo4(),
                richiesteDto.getUtenteInserimento(), richiesteDto.getDataInserimento(),
                richiesteDto.getUtenteModifica(),richiesteDto.getDataModifica());
        richiesteRepository.save(newRichesta);


        return richiesteRepository.save(newRichesta);// ;
    }/**richiesta.setStatoApprovazione(
       StatoApprovazione.valueOf(
               (nuovaRichiesta.getStatoApprovazione()).name()
       )
               );**/



    @Override
    public List<Richieste> getAllRichieste() {
        return richiesteRepository.findAll();
    }

    @Override
    public Richieste getRichiesteById(long id) {
        return richiesteRepository.findById(id).orElseThrow(()-> new
                ResourceNotFoundException("Richieste","id",id));
    }

    @Override
    public Richieste updateRichieste(RichiesteDto richiesteDto, long id) {

        Richieste existingRichieste = richiesteRepository.findById(id)
                .orElseThrow( ()-> new ResourceNotFoundException("Richieste","Id",id)) ;

        Optional<Stato> optionalStato = statoRepository.findById(richiesteDto.getStatoId());
        if (optionalStato.isEmpty()) {
            throw new ResourceNotFoundException("Stato", "Id", richiesteDto.getStatoId());
        }
        Stato stato = optionalStato.get();

        Optional<StatoApprovazione> optionalStatoApprovazione = statoApprovazioneRepository.findById
                (richiesteDto.getStatoApprovazioneId());
        if (optionalStatoApprovazione.isEmpty()) {
            throw new ResourceNotFoundException("StatoApprovazione", "Id", richiesteDto.getStatoApprovazioneId());
        }
        StatoApprovazione statoApprovazione = optionalStatoApprovazione.get();


        	existingRichieste.setId(richiesteDto.getId());
   	        existingRichieste.setIdCommessa(richiesteDto.getIdCommessa());
		    existingRichieste.setOggetto(richiesteDto.getOggetto());

            existingRichieste.setStato(stato);
            existingRichieste.setDataCreazione(richiesteDto.getDataCreazione());
           existingRichieste.setStatoApprovazione(statoApprovazione);
            existingRichieste.setNote(richiesteDto.getNote());
        existingRichieste.setCampo1(richiesteDto.getCampo1());
        existingRichieste.setCampo1(richiesteDto.getCampo2());
        existingRichieste.setCampo1(richiesteDto.getCampo3());
        existingRichieste.setCampo1(richiesteDto.getCampo4());
        existingRichieste.setUtenteInserimento(richiesteDto.getUtenteInserimento());
        existingRichieste.setDataInserimento(richiesteDto.getDataInserimento());
        existingRichieste.setUtenteModifica(richiesteDto.getUtenteModifica());
        existingRichieste.setDataModifica(richiesteDto.getDataModifica());
        richiesteRepository.save(existingRichieste);
        return existingRichieste;
    }

    @Override
    public void deleteRichieste(long id) {
        richiesteRepository.findById(id).orElseThrow(
                ()->(new ResourceNotFoundException("Richieste","id",id)));
        richiesteRepository.deleteById(id);

    }
}
