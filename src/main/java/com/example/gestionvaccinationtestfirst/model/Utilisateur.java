package com.example.gestionvaccinationtestfirst.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Utilisateur {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String prenom;

    private String addresse;

    @Column(unique = true)
    private String email;

    private String telephone;

    private String password;

    @ManyToOne
    @JoinColumn(name = "centreVaccination_id")
    private Centre centre;

    @OneToMany(mappedBy = "parent",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Carnet> carnetList;



}
