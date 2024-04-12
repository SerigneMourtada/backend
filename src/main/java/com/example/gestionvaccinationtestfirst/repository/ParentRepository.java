package com.example.gestionvaccinationtestfirst.repository;

import com.example.gestionvaccinationtestfirst.DTos.ParentDTO;
import com.example.gestionvaccinationtestfirst.model.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParentRepository extends JpaRepository<Parent,Long> {

    @Query("select p from Parent p where upper(p.nom) = upper(?1) and upper(p.prenom) = upper(?2)")
    Parent findByNomIgnoreCaseAndPrenomIgnoreCase(String nom, String prenom);

    @Query("select p from Parent p where upper(p.nom) = upper(?1)")
    Parent findByNomIgnoreCase(String nom);


    @Query("select p from Parent p where upper(p.prenom) = upper(?1)")
    Parent findByPrenomIgnoreCase(String prenom);

    @Query("select p from Parent p inner join p.centreVaccination.parents parents where parents.telephone = ?1")
    Parent findByCentreVaccination_Parents_Telephone(String telephone);
}
