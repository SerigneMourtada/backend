package com.example.gestionvaccinationtestfirst.repository;

import com.example.gestionvaccinationtestfirst.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long>{
    @Query("select u from Utilisateur u where u.email = ?1")
    Utilisateur findByEmail(String email);

    @Query("select u from Utilisateur u where upper(u.telephone) = upper(?1)")
    List<Utilisateur> findByTelephoneIgnoreCase(String telephone);

    @Query("select u from Utilisateur u where upper(u.telephone) = upper(?1) and upper(u.email) = upper(?2)")
    List<Utilisateur> findByTelephoneIgnoreCaseAndEmailIgnoreCase(String telephone, String email);
}
