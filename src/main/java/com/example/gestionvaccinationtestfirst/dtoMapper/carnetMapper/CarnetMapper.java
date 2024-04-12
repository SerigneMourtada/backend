package com.example.gestionvaccinationtestfirst.dtoMapper.carnetMapper;

import com.example.gestionvaccinationtestfirst.DTos.CarnetVaccinationDTO;
import com.example.gestionvaccinationtestfirst.dtoMapper.Utilisateur.UtilisateurMapper;
import com.example.gestionvaccinationtestfirst.dtoMapper.enfantMapper.EnfantMapper;
import com.example.gestionvaccinationtestfirst.model.Carnet;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarnetMapper {
    private EnfantMapper enfantMapper;

    private UtilisateurMapper utilisateurMapper;

    public Carnet fromCarnetDTO(CarnetVaccinationDTO carnetVaccinationDTO){
        Carnet carnet=new Carnet();
        carnet.setEnfant(enfantMapper.fromEnfantDTO(carnetVaccinationDTO.getEnfantDTO()));
        carnet.setUtilisateur(utilisateurMapper.fromUtilisateurDTO(carnetVaccinationDTO.getUtilisateurDTO()));
        return carnet;
    }


    public CarnetVaccinationDTO fromCarnet(Carnet carnet){
        CarnetVaccinationDTO carnetVaccinationDTO=new CarnetVaccinationDTO();
        carnetVaccinationDTO.setEnfantDTO(enfantMapper.fromEnfant(carnet.getEnfant()));
        carnetVaccinationDTO.setUtilisateurDTO(utilisateurMapper.fromUtilisateur(carnet.getUtilisateur()));

        return carnetVaccinationDTO;
    }

}
