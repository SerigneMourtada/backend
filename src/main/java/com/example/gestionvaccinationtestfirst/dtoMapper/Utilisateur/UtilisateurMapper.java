package com.example.gestionvaccinationtestfirst.dtoMapper.Utilisateur;

import com.example.gestionvaccinationtestfirst.DTos.UtilisateurDTO;
import com.example.gestionvaccinationtestfirst.dtoMapper.centreMapper.CentreVaccMapper;
import com.example.gestionvaccinationtestfirst.model.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UtilisateurMapper {
    private CentreVaccMapper centreVaccMapper;
    public Utilisateur fromUtilisateurDTO(UtilisateurDTO utilisateurDTO){
        Utilisateur utilisateur=new Utilisateur();
        BeanUtils.copyProperties(utilisateurDTO,utilisateur);
        utilisateur.setCentreVaccination(centreVaccMapper.fromCentreVaccinationDTO(utilisateurDTO.getCentreVaccinationDTO()));
        return utilisateur;
    }

    public UtilisateurDTO fromUtilisateur(Utilisateur utilisateur){
        UtilisateurDTO utilisateurDTO=new UtilisateurDTO();
        BeanUtils.copyProperties(utilisateur,utilisateurDTO);
        utilisateurDTO.setCentreVaccinationDTO(centreVaccMapper.fromCentreVaccination(utilisateur.getCentreVaccination()));
        return utilisateurDTO;
    }
}
