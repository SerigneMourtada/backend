package com.example.gestionvaccinationtestfirst.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Enfant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String nom;

    private String prenom;

    private  String sexe;

    private LocalDate dateDeNaissance;

   @ManyToOne
    private Parent parent;

   @OneToMany(mappedBy = "enfant",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Consultation> consultations;


   @OneToOne(mappedBy = "enfant",cascade = CascadeType.ALL, orphanRemoval = true)
    private Carnet carnet;





}
