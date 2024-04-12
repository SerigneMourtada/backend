package com.example.gestionvaccinationtestfirst.model;

import com.example.gestionvaccinationtestfirst.enumerations.Etat_Rendez_Vous;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Rendez_Vous {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate  date;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime heure;

    private String telephone;

    private Etat_Rendez_Vous etat_rendez_vous;


    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToOne
    private Carnet carnet;


}
