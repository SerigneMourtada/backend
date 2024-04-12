package com.example.gestionvaccinationtestfirst.DTos;

import com.example.gestionvaccinationtestfirst.model.Enfant;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class CarnetVaccinationDTO {
    private Long id;

    private EnfantDTO enfantDTO;

    private UtilisateurDTO utilisateurDTO;

}
