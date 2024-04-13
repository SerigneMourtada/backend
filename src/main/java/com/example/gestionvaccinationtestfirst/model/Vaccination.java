package com.example.gestionvaccinationtestfirst.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Vaccination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private  LocalDate date;

    private Long nombreDeDose;


    @ManyToOne
    @JoinColumn(name = "vaccin_id")
    private Vaccin vaccin;


    @ManyToOne
    private  Carnet carnet;


}

