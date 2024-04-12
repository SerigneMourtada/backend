package com.example.gestionvaccinationtestfirst.service.CentreVaccinationService;

import com.example.gestionvaccinationtestfirst.DTos.CentreVaccinationDTO;
import com.example.gestionvaccinationtestfirst.Excepyion.CentreNotFoundException;
import com.example.gestionvaccinationtestfirst.dtoMapper.centreMapper.CentreVaccMapper;
import com.example.gestionvaccinationtestfirst.model.CentreVaccination;
import com.example.gestionvaccinationtestfirst.repository.CentreVaccinationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CentreVaccServImpl implements CentreVaccServ {
    private CentreVaccinationRepository centreVaccinationRepository;

    private CentreVaccMapper centreVaccMapper;

    @Override
    public List<CentreVaccinationDTO> getAllCentre() throws CentreNotFoundException {
        List<CentreVaccination> centreVaccinationList = centreVaccinationRepository.findAll();
        List<CentreVaccinationDTO> centreVaccinationDTOList = centreVaccinationList.stream()
                .map(centre -> centreVaccMapper.fromCentreVaccination(centre))
                .collect(Collectors.toList());
        return centreVaccinationDTOList;
    }

    @Override
    public CentreVaccinationDTO saveCentreVaccination(CentreVaccinationDTO centreVaccinationDTO) {
        CentreVaccination centreVaccination = centreVaccMapper.
                fromCentreVaccinationDTO(centreVaccinationDTO);

        CentreVaccination centreVaccination1 = centreVaccinationRepository.save(centreVaccination);
        return centreVaccMapper.fromCentreVaccination(centreVaccination1);
    }

    @Override
    public CentreVaccinationDTO getCentreById(Long centreId) throws CentreNotFoundException {
        CentreVaccination centre = centreVaccinationRepository.findById(centreId)

                .orElseThrow(() -> new CentreNotFoundException("Centre est introuvable"));
        return centreVaccMapper.fromCentreVaccination(centre);
    }

    @Override
    public void deleteCentre(Long id) {
        centreVaccinationRepository.deleteById(id);

    }

    @Override
    public CentreVaccinationDTO updateCentre(CentreVaccinationDTO centreVaccinationDTO) {

        CentreVaccination centreVaccination = centreVaccMapper.fromCentreVaccinationDTO(centreVaccinationDTO);
        CentreVaccination centreVaccination1 = centreVaccinationRepository.save(centreVaccination);
        return centreVaccMapper.fromCentreVaccination(centreVaccination1);
    }
}

