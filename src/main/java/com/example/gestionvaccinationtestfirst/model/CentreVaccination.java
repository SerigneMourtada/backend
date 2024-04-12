package com.example.gestionvaccinationtestfirst.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class CentreVaccination {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String addresse;

    private LocalTime heure_Ouverture;

    private LocalTime heure_De_Fermeture;

    private String email;

    @OneToMany(mappedBy = "centreVaccination",fetch = FetchType.EAGER)
    private List<Parent> parents=new ArrayList<>();


    @OneToMany(mappedBy = "centreVaccination",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Utilisateur> utilisateurs;



}
