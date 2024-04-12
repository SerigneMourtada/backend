package com.example.gestionvaccinationtestfirst.DTos;

import com.example.gestionvaccinationtestfirst.model.Parent;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
public class CentreVaccinationDTO {
    private Long id;

    private String nom;

    private String addresse;

    private LocalTime heure_Ouverture;

    private LocalTime heure_De_Fermeture;

    private String email;




}
