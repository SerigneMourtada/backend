package com.example.gestionvaccinationtestfirst.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Parent {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String prenom;

    private String addresse;

    private String telephone;

    private String LienDeParente;


    @OneToMany(mappedBy = "parent",cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Enfant> enfants;

    @ManyToOne
    private Centre centre;

    @OneToOne(orphanRemoval = true)
      private Rendez_Vous rendezVous;


}
