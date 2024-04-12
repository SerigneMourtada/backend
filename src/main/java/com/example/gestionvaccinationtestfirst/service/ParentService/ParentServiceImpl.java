package com.example.gestionvaccinationtestfirst.service.ParentService;

import com.example.gestionvaccinationtestfirst.DTos.CentreVaccinationDTO;
import com.example.gestionvaccinationtestfirst.DTos.ParentDTO;
import com.example.gestionvaccinationtestfirst.Excepyion.CentreNotFoundException;
import com.example.gestionvaccinationtestfirst.Excepyion.ParentNotFoundException;
import com.example.gestionvaccinationtestfirst.dtoMapper.centreMapper.CentreVaccMapper;
import com.example.gestionvaccinationtestfirst.dtoMapper.parentMapper.ParentMapper;
import com.example.gestionvaccinationtestfirst.model.CentreVaccination;
import com.example.gestionvaccinationtestfirst.model.Parent;
import com.example.gestionvaccinationtestfirst.repository.CentreVaccinationRepository;
import com.example.gestionvaccinationtestfirst.repository.ParentRepository;
import com.example.gestionvaccinationtestfirst.repository.UtilisateurRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
@AllArgsConstructor

public class ParentServiceImpl implements ParentService{
    private CentreVaccinationRepository centreVaccinationRepository;

    private CentreVaccMapper centreVaccMapper;

    private ParentRepository parentRepository;

    private UtilisateurRepository utilisateurRepository;

    private ParentMapper parentMapper;
    @Override
    public List<ParentDTO> getAllParents() {
        List<Parent> parents=parentRepository.findAll();
       List<ParentDTO> parentDTOS= parents.stream()
               .map(parent -> parentMapper.fromParent(parent))
               .collect(Collectors.toList());
        return parentDTOS;
    }

    @Override
    public ParentDTO getParent(Long parentId) throws ParentNotFoundException {
        Parent parent=parentRepository.findById(parentId)
                .orElseThrow(()->new ParentNotFoundException("Parent Not Found"));
        return parentMapper.fromParent(parent);
    }

    @Override
    public void deleteParent(Long parentId) {
        parentRepository.deleteById(parentId);

    }


    @Override
    public ParentDTO saveParent(ParentDTO parentDTO, String email){
        CentreVaccination centre= utilisateurRepository.findByEmail(email).getCentreVaccination();

        CentreVaccinationDTO centreVaccinationDTO=centreVaccMapper.fromCentreVaccination(centre);
        //centreVaccinationDTO.getParentsDTO().add(parentDTO);

        parentDTO.setCentreVaccinationDTO(centreVaccinationDTO);

        Parent parent=parentMapper.fromParentDTO(parentDTO);

        centre.getParents().add(parent);

        Parent parent1=parentRepository.save(parentMapper.fromParentDTO(parentDTO));


        return parentMapper.fromParent(parent1);
    }

    @Override
    public ParentDTO updateParent(ParentDTO parentDTO){
        Parent parent=parentMapper.fromParentDTO(parentDTO);
        parentRepository.save(parent);
        return parentMapper.fromParent(parent);
    }

    @Override
    public ParentDTO saveParent(ParentDTO parentDTO, Long centreId) throws CentreNotFoundException {
       CentreVaccination centre= centreVaccinationRepository.findById(centreId).
                orElseThrow(()->new CentreNotFoundException("Centre Introuvable"));

       CentreVaccinationDTO centreVaccinationDTO=centreVaccMapper.fromCentreVaccination(centre);
       parentDTO.setCentreVaccinationDTO(centreVaccinationDTO);


      Parent parent= parentMapper.fromParentDTO(parentDTO);

      centre.getParents().add(parent);

      Parent parent1=parentRepository.save(parent);

        return parentMapper.fromParent(parent1);
    }
}
