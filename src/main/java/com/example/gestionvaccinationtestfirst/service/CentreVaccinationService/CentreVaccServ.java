package com.example.gestionvaccinationtestfirst.service.CentreVaccinationService;

import com.example.gestionvaccinationtestfirst.DTos.CentreVaccinationDTO;
import com.example.gestionvaccinationtestfirst.Excepyion.CentreNotFoundException;

import java.util.List;

public interface CentreVaccServ {

    public List<CentreVaccinationDTO> getAllCentre()throws CentreNotFoundException;


    public CentreVaccinationDTO saveCentreVaccination(CentreVaccinationDTO centreVaccinationDTO);

    public CentreVaccinationDTO getCentreById(Long centreId) throws CentreNotFoundException  ;

    public void deleteCentre(Long id);

    CentreVaccinationDTO updateCentre(CentreVaccinationDTO centreVaccinationDTO);
}
