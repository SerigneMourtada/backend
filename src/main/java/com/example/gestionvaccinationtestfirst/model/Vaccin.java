package com.example.gestionvaccinationtestfirst.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Vaccin {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomVaccin;

    private Long numeroDeLot;

    private String effetSecondaires;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Maladie> maladies=new ArrayList<>();

    @OneToMany(mappedBy ="vaccin",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vaccination> vaccinationList;


}
