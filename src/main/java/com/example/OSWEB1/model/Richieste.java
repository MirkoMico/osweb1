package com.example.OSWEB1.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Richieste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long idCommessa;
    private String oggetto;
    @ManyToOne
     private Stato stato;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataCreazione;
    @ManyToOne
    private StatoApprovazione statoApprovazione;
    private String note;
    private String campo1;
    private String campo2;
    private String campo3;
    private String campo4;
   private String utenteInserimento;
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataInserimento;
   private String utenteModifica;
   @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataModifica;

    public Richieste(long idCommessa, String oggetto, Stato stato, LocalDateTime dataCreazione,
                     StatoApprovazione statoApprovazione, String note,
                     String campo1, String campo2, String campo3, String campo4,String utenteInserimento,
                     LocalDateTime dataInserimento, String utenteModifica, LocalDateTime dataModifica) {
        this.idCommessa = idCommessa;
        this.oggetto = oggetto;
        this.stato = stato;
        this.dataCreazione = dataCreazione;
        this.statoApprovazione = statoApprovazione;
        this.note = note;
        this.campo1 = campo1;
        this.campo2 = campo2;
        this.campo3 = campo3;
        this.campo4 = campo4;
        this.utenteInserimento= utenteInserimento;
        this.dataInserimento = dataInserimento;
        this.utenteModifica= utenteModifica;
        this.dataModifica = dataModifica;
    }
}
