package com.example.gestionvaccinationtestfirst.service.carnetService;

import com.example.gestionvaccinationtestfirst.DTos.CarnetVaccinationDTO;
import com.example.gestionvaccinationtestfirst.DTos.EnfantDTO;
import com.example.gestionvaccinationtestfirst.DTos.UtilisateurDTO;
import com.example.gestionvaccinationtestfirst.Excepyion.CarnetVaccinationNotFoundException;
import com.example.gestionvaccinationtestfirst.Excepyion.EnfantNotFoundException;
import com.example.gestionvaccinationtestfirst.Excepyion.UtilisateurNotFoundException;
import com.example.gestionvaccinationtestfirst.dtoMapper.Utilisateur.UtilisateurMapper;
import com.example.gestionvaccinationtestfirst.dtoMapper.carnetMapper.CarnetMapper;
import com.example.gestionvaccinationtestfirst.dtoMapper.enfantMapper.EnfantMapper;
import com.example.gestionvaccinationtestfirst.model.Carnet;
import com.example.gestionvaccinationtestfirst.model.Enfant;
import com.example.gestionvaccinationtestfirst.model.Utilisateur;
import com.example.gestionvaccinationtestfirst.repository.CarnetRepository;
import com.example.gestionvaccinationtestfirst.repository.EnfantRepository;
import com.example.gestionvaccinationtestfirst.repository.UtilisateurRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarnetServImpl implements CarnetServ{
    private CarnetRepository carnetRepository;

    private CarnetMapper carnetMapper;

    private EnfantRepository enfantRepository;

    private UtilisateurRepository utilisateurRepository;

    private EnfantMapper enfantMapper;

    private UtilisateurMapper utilisateurMapper;
    @Override
    public CarnetVaccinationDTO getCarnetById(Long carnetId) throws CarnetVaccinationNotFoundException {
       Carnet carnet= carnetRepository.findById(carnetId)
                .orElseThrow(()->new CarnetVaccinationNotFoundException("Carnet does not found"));

        return carnetMapper.fromCarnet(carnet);
    }

    @Override
    public void deleteCarnet(Long carnetId) throws CarnetVaccinationNotFoundException {
        Carnet carnet=carnetRepository.findById(carnetId)
                .orElseThrow(()->new CarnetVaccinationNotFoundException("Carnet does not found"));

    }

    @Override
    public CarnetVaccinationDTO updateCarnet(CarnetVaccinationDTO carnetVaccinationDTO){
        Carnet carnet=carnetMapper.fromCarnetDTO(carnetVaccinationDTO);
        Carnet carnet1=carnetRepository.save(carnet);
        return carnetMapper.fromCarnet(carnet1);
    }

    @Override
    public CarnetVaccinationDTO saveCarnet(CarnetVaccinationDTO carnetVaccinationDTO, Long enfantId, Long userId) throws EnfantNotFoundException, UtilisateurNotFoundException {
        Enfant enfant=enfantRepository.findById(enfantId)
                .orElseThrow(()->new EnfantNotFoundException("Enfant Does not Found"));

        Utilisateur utilisateur=utilisateurRepository.findById(userId)
                .orElseThrow(()->new UtilisateurNotFoundException("User does not found"));

        EnfantDTO enfantDTO=enfantMapper.fromEnfant(enfant);
        UtilisateurDTO utilisateurDTO=utilisateurMapper.fromUtilisateur(utilisateur);

        carnetVaccinationDTO.setEnfantDTO(enfantDTO);
        carnetVaccinationDTO.setUtilisateurDTO(utilisateurDTO);
        Carnet carnet=carnetMapper.fromCarnetDTO(carnetVaccinationDTO);
        Carnet carnet1=carnetRepository.save(carnet);

        return carnetMapper.fromCarnet(carnet1);
    }
}
