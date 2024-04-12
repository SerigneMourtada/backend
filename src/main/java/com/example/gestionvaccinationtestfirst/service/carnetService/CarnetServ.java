package com.example.gestionvaccinationtestfirst.service.carnetService;

import com.example.gestionvaccinationtestfirst.DTos.CarnetVaccinationDTO;
import com.example.gestionvaccinationtestfirst.Excepyion.CarnetVaccinationNotFoundException;
import com.example.gestionvaccinationtestfirst.Excepyion.EnfantNotFoundException;
import com.example.gestionvaccinationtestfirst.Excepyion.UtilisateurNotFoundException;
import org.hibernate.mapping.List;

public interface CarnetServ {

   // public List<CarnetVaccinationDTO> getAllCarnet();
    public CarnetVaccinationDTO getCarnetById(Long carnetId) throws CarnetVaccinationNotFoundException;

    public void deleteCarnet(Long carnetId) throws CarnetVaccinationNotFoundException;

    public CarnetVaccinationDTO updateCarnet(CarnetVaccinationDTO carnetVaccinationDTO);

    public CarnetVaccinationDTO saveCarnet(CarnetVaccinationDTO carnetVaccinationDTO,Long enfantId,Long userId) throws EnfantNotFoundException, UtilisateurNotFoundException;
}
