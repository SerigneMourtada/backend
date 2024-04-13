package com.example.gestionvaccinationtestfirst.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor 
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Enfant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String nom;

    private String prenom;

    String sexe;

    private LocalDate dateDeNaissance;

   @ManyToOne
    Parent parent;

   @OneToMany(mappedBy = "enfant",cascade = CascadeType.ALL, orphanRemoval = true)
    List<Consultation> consultations;


   @OneToOne(mappedBy = "enfant",cascade = CascadeType.ALL, orphanRemoval = true)
    private Carnet carnet;





}
