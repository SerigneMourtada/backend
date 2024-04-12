package com.example.gestionvaccinationtestfirst.service.UserService;

import com.example.gestionvaccinationtestfirst.DTos.CentreVaccinationDTO;
import com.example.gestionvaccinationtestfirst.DTos.UtilisateurDTO;
import com.example.gestionvaccinationtestfirst.Excepyion.CentreNotFoundException;
import com.example.gestionvaccinationtestfirst.Excepyion.UtilisateurNotFoundException;

import java.util.List;

public interface UtilisateurService {

    public List<UtilisateurDTO> getAllUsers();

    public UtilisateurDTO getUserBYId(Long userId) throws UtilisateurNotFoundException;

    public void deleteUser(Long userId);

    public UtilisateurDTO saveUser(UtilisateurDTO utilisateurDTO,Long centreId) throws CentreNotFoundException;

    public UtilisateurDTO updateUser(UtilisateurDTO utilisateurDTO);

}
