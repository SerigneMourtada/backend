package com.example.gestionvaccinationtestfirst.DTos;

import com.example.gestionvaccinationtestfirst.enumerations.Etat_Rendez_Vous;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
@Data
public class RendezVousDTO {
    private Long id;

    private LocalDate date;

    private LocalTime heure;

    private String telephone;

    private Etat_Rendez_Vous etat_rendez_vous;



    private ParentDTO parentDTO;


    private UtilisateurDTO utilisateurDTO;

}
