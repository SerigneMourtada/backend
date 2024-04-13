package com.example.gestionvaccinationtestfirst.DTos;

import lombok.Data;

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
