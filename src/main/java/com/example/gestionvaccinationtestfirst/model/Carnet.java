package com.example.gestionvaccinationtestfirst.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Carnet {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "enfant_id", referencedColumnName = "id")
    private Enfant enfant;

    @OneToMany(mappedBy = "carnet")
    private List<Rendez_Vous> rendezVousList;


    @ManyToOne
    private Utilisateur utilisateur;


    @OneToMany(mappedBy = "carnet",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vaccination> vaccinationList;
}
