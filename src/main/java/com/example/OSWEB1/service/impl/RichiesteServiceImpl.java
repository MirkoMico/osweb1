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


        Richieste newRichesta=new Richieste(richiesteDto.getIdCommessa(),
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
    public Richieste updateRichieste(Richieste richieste, long id) {
        Richieste existingRichieste = richiesteRepository.findById(id)
                .orElseThrow( ()-> new ResourceNotFoundException("Richieste","Id",id)) ;
        	existingRichieste.setId(richieste.getId());
   	        existingRichieste.setIdCommessa(richieste.getIdCommessa());
		    existingRichieste.setOggetto(richieste.getOggetto());
            //existingRichieste.setStato(richieste.getStato());
            existingRichieste.setDataCreazione(richieste.getDataCreazione());
            existingRichieste.setStatoApprovazione(richieste.getStatoApprovazione());
            existingRichieste.setNote(richieste.getNote());
        existingRichieste.setCampo1(richieste.getCampo1());
        existingRichieste.setCampo1(richieste.getCampo2());
        existingRichieste.setCampo1(richieste.getCampo3());
        existingRichieste.setCampo1(richieste.getCampo4());
      //  existingRichieste.setUtenteInserimento(richieste.getUtenteInserimento);
        existingRichieste.setDataInserimento(richieste.getDataInserimento());
     //   existingRichieste.setRichiesteModifica(richieste.getRichiesteModifica);
        existingRichieste.setDataModifica(richieste.getDataModifica());
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
