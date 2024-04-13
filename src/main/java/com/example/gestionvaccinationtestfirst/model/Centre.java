package com.example.gestionvaccinationtestfirst.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Centre {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String addresse;

    private LocalTime heure_Ouverture;

    private LocalTime heure_De_Fermeture;

    private String email;




}
