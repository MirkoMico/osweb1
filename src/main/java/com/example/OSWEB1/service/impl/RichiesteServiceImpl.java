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
    public Richieste saveRichieste(Richieste richieste) {
       // Optional<Stato> optionalStato= statoRepository.findById(richieste.getStato().getIdStato());
        //if (optionalStato.isEmpty()){
        //    return null;
       // }
        Stato stato= statoRepository.findById(richieste.getStato().getIdStato()).orElse(null);
        //Optional<StatoApprovazione> optionalStatoApprovazione=
        //        statoApprovazioneRepository.findById(richieste.getStatoApprovazione().getIdStatoApp());
        //if (optionalStato.isEmpty()){
        //    return null;
        // }
        Richieste newRichesta= new Richieste();
        StatoApprovazione statoApprovazione= statoApprovazioneRepository.
                findById(richieste.getStatoApprovazione().getIdStatoApp())
                .orElse(null);

        newRichesta.setIdCommessa(richieste.getIdCommessa());
        newRichesta.setOggetto(richieste.getOggetto());
        newRichesta.setStato(stato);
        newRichesta.setDataCreazione(richieste.getDataCreazione());
        newRichesta.setStatoApprovazione(statoApprovazione);
        newRichesta.setNote(richieste.getNote());
        newRichesta.setCampo1(richieste.getCampo1());
        newRichesta.setCampo2(richieste.getCampo2());
        newRichesta.setCampo3(richieste.getCampo3());
        newRichesta.setCampo4(richieste.getCampo4());


       /* Richieste newRichesta=new Richieste(richieste.getIdCommessa(),
                richieste.getOggetto(),stato,richieste.getDataCreazione(),
                statoApprovazione,richieste.getNote(),
                richieste.getCampo1(),richieste.getCampo2(),richieste.getCampo3(),richieste.getCampo4(),
                richieste.getUtenteInserimento(), richieste.getDataInserimento(),
                richieste.getUtenteModifica(),richieste.getDataModifica());*/
        //richiesteRepository.save(newRichesta);


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
                .orElseThrow( ()-> new ResourceNotFoundException("Richieste","Id" , id)) ;

     /*   Optional<Stato> optionalStato = statoRepository.findById(richieste.getStatoId());
        if (optionalStato.isEmpty()) {
            throw new ResourceNotFoundException("Stato", "Id", richiesteDto.getStatoId());
        }
        Stato stato = optionalStato.get();

        Optional<StatoApprovazione> optionalStatoApprovazione = statoApprovazioneRepository.findById
                (richiesteDto.getStatoApprovazioneId());
        if (optionalStatoApprovazione.isEmpty()) {
            throw new ResourceNotFoundException("StatoApprovazione", "Id", richiesteDto.getStatoApprovazioneId());

        StatoApprovazione statoApprovazione = optionalStatoApprovazione.get();
*/

        	existingRichieste.setId(richieste.getId());
   	        existingRichieste.setIdCommessa(richieste.getIdCommessa());
		    existingRichieste.setOggetto(richieste.getOggetto());

            existingRichieste.setStato(richieste.getStato());
            existingRichieste.setDataCreazione(richieste.getDataCreazione());
           existingRichieste.setStatoApprovazione(richieste.getStatoApprovazione());
            existingRichieste.setNote(richieste.getNote());
        existingRichieste.setCampo1(richieste.getCampo1());
        existingRichieste.setCampo1(richieste.getCampo2());
        existingRichieste.setCampo1(richieste.getCampo3());
        existingRichieste.setCampo1(richieste.getCampo4());
        existingRichieste.setUtenteInserimento(richieste.getUtenteInserimento());
        existingRichieste.setDataInserimento(richieste.getDataInserimento());
        existingRichieste.setUtenteModifica(richieste.getUtenteModifica());
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
