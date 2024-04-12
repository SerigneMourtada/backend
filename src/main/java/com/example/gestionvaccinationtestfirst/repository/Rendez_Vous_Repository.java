package com.example.gestionvaccinationtestfirst.repository;

import com.example.gestionvaccinationtestfirst.model.Rendez_Vous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface Rendez_Vous_Repository extends JpaRepository<Rendez_Vous,Long> {

    @Query("select r from Rendez_Vous r where r.utilisateur.email = ?1")
    List<Rendez_Vous> findByUtilisateur_Email(String email);
}
