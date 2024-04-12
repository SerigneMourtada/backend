package com.example.gestionvaccinationtestfirst.repository;

import com.example.gestionvaccinationtestfirst.model.Vaccination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VaccinationRepository extends JpaRepository<Vaccination,Long> {
    @Query("SELECT v FROM Vaccination v JOIN FETCH v.enfant e JOIN FETCH v.vaccin WHERE e.id = :enfantId")
    List<Object[]> findVaccinationsByEnfantId(@Param("enfantId") Long enfantId);



    @Query("SELECT v FROM Vaccination v JOIN FETCH v.enfant e JOIN FETCH v.vaccin WHERE e.id = :enfantId")
    List<Object[]> findCarnetVaccinationByEnfantId(@Param("enfantId") Long enfantId);

    List<Vaccination> findVaccinationsById(Long enfantId);

}
