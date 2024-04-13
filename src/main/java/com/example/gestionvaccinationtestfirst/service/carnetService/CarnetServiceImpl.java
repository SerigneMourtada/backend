package com.example.gestionvaccinationtestfirst.service.carnetService;

import com.example.gestionvaccinationtestfirst.DTos.CarnetDTO;
import com.example.gestionvaccinationtestfirst.DTos.EnfantDTO;
import com.example.gestionvaccinationtestfirst.DTos.UtilisateurDTO;
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
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
@AllArgsConstructor
public class CarnetServiceImpl implements CarnetService {
    private CarnetRepository carnetRepository;

    private CarnetMapper carnetMapper;

    private EnfantRepository enfantRepository;

    private UtilisateurRepository utilisateurRepository;

    private EnfantMapper enfantMapper;

    private UtilisateurMapper utilisateurMapper;

    @Override
    public List<CarnetDTO> readCarnets() {
        List<Carnet> carnets = carnetRepository.findAll();
        return carnetMapper.asCarnetDTOs(carnets);
    }

    @Override
    public CarnetDTO getCarnetById(Long carnetId){
        Carnet carnet= carnetRepository.findById(carnetId).
                orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Not found kpi with id {0}", carnetId)));
        return carnetMapper.asCarnetDTO(carnet);
    }

    @Override
    public CarnetDTO createCarnet(CarnetDTO carnetDTO) {
        return carnetMapper.asCarnetDTO(carnetRepository.save(carnetMapper.asCarnet(carnetDTO)));
    }

    @Override
    public CarnetDTO updateCarnet(CarnetDTO carnetDTO) {
        Carnet carnet= carnetRepository.findById(carnetDTO.getId()).
                orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Not found kpi with id {0}", carnetDTO.getId())));

        return carnetMapper.asCarnetDTO(carnetRepository.save(carnet));
    }

    @Override
    public void deleteCarnet(Long CarnetDTOId) {
        Carnet carnet= carnetRepository.findById(CarnetDTOId).
                orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Not found kpi with id {0}", CarnetDTOId)));

        carnetRepository.delete(carnet);
    }
}
