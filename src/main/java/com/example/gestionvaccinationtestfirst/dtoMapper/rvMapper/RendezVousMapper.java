package com.example.gestionvaccinationtestfirst.dtoMapper.rvMapper;

import com.example.gestionvaccinationtestfirst.DTos.RendezVousDTO;
import com.example.gestionvaccinationtestfirst.dtoMapper.Utilisateur.UtilisateurMapper;
import com.example.gestionvaccinationtestfirst.dtoMapper.parentMapper.ParentMapper;
import com.example.gestionvaccinationtestfirst.model.Rendez_Vous;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RendezVousMapper {
    private ParentMapper parentMapper;
    private UtilisateurMapper utilisateurMapper;

    public RendezVousDTO fromRendezVous(Rendez_Vous  rendezVous){
        RendezVousDTO rendezVousDTO=new RendezVousDTO();
        BeanUtils.copyProperties(rendezVous,rendezVousDTO);
        rendezVousDTO.setParentDTO(parentMapper.fromParent(rendezVous.getParent()));
        rendezVousDTO.setUtilisateurDTO(utilisateurMapper.fromUtilisateur(rendezVous.getUtilisateur()));
        return rendezVousDTO;
    }

    public Rendez_Vous fromRendezVousDTO(RendezVousDTO rendezVousDTO){
        Rendez_Vous rendezVous=new Rendez_Vous();
        BeanUtils.copyProperties(rendezVousDTO,rendezVous);
        rendezVous.setParent(parentMapper.fromParentDTO(rendezVousDTO.getParentDTO()));
        rendezVous.setUtilisateur(utilisateurMapper.fromUtilisateurDTO(rendezVousDTO.getUtilisateurDTO()));
        return rendezVous;
    }

}
