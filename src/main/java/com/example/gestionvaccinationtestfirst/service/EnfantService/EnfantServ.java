package com.example.gestionvaccinationtestfirst.service.EnfantService;

import com.example.gestionvaccinationtestfirst.DTos.EnfantDTO;
import com.example.gestionvaccinationtestfirst.DTos.ParentDTO;
import com.example.gestionvaccinationtestfirst.Excepyion.EnfantNotFoundException;
import com.example.gestionvaccinationtestfirst.Excepyion.ParentNotFoundException;

import java.util.List;

public interface EnfantServ {
    public List<EnfantDTO> getAllEnfants();

    public EnfantDTO getEnfantById(Long enfantId) throws EnfantNotFoundException;

    public void deleteEnfant(Long enfantId);



    public EnfantDTO updateEnfant(EnfantDTO enfantDTO);

    public EnfantDTO saveEnfant(EnfantDTO enfantDTO,String nom,String prenom,String telephone,String addresse,String lien);

    public EnfantDTO saveEnfant(EnfantDTO enfantDTO,Long parentId) throws ParentNotFoundException;


}
