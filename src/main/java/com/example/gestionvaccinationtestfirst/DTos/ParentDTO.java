package com.example.gestionvaccinationtestfirst.DTos;

import com.example.gestionvaccinationtestfirst.model.CentreVaccination;
import com.example.gestionvaccinationtestfirst.model.Enfant;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Collection;

@Data
public class ParentDTO{
    private Long id;

    private String nom;

    private String prenom;

    private String addresse;

    private String telephone;


    private String lienDeParente;


    private CentreVaccinationDTO centreVaccinationDTO;
}
