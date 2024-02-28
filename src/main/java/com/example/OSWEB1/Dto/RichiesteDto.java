package com.example.OSWEB1.Dto;

import com.example.OSWEB1.model.Stato;
import com.example.OSWEB1.model.StatoApprovazione;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RichiesteDto {

    private long idCommessa;
    private String oggetto;
    int statoId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataCreazione;
    //private StatoApprovazione statoApprovazione;
    int statoApprovazioneId;
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
}
