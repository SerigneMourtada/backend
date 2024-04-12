package com.example.gestionvaccinationtestfirst.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
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
    private CentreVaccination centreVaccination;

    @OneToMany(mappedBy ="utilisateur",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rendez_Vous> rendezVousList=new ArrayList<>();


    @OneToMany(mappedBy ="utilisateur",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vaccination> vaccinationList;

    @OneToMany(mappedBy = "utilisateur",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Carnet> carnetList;



}
