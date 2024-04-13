package com.example.gestionvaccinationtestfirst.service.ParentService;

import com.example.gestionvaccinationtestfirst.DTos.CentreDTO;
import com.example.gestionvaccinationtestfirst.DTos.ParentDTO;
import com.example.gestionvaccinationtestfirst.dtoMapper.centreMapper.CentreMapper;
import com.example.gestionvaccinationtestfirst.dtoMapper.parentMapper.ParentMapper;
import com.example.gestionvaccinationtestfirst.model.Centre;
import com.example.gestionvaccinationtestfirst.model.Parent;
import com.example.gestionvaccinationtestfirst.repository.CentreRepository;
import com.example.gestionvaccinationtestfirst.repository.ParentRepository;
import com.example.gestionvaccinationtestfirst.repository.UtilisateurRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
@AllArgsConstructor

public class ParentServiceImpl implements ParentService{
    private CentreRepository centreRepository;

    private CentreMapper centreVaccMapper;

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
    public ParentDTO getParent(Long parentId){
        Parent parent=parentRepository.findById(parentId).
                orElseThrow(() -> new jakarta.persistence.EntityNotFoundException(MessageFormat.format("Not found kpi with id {0}", parentId)));
        return parentMapper.fromParent(parent);
    }

    @Override
    public void deleteParent(Long parentId) {
        parentRepository.deleteById(parentId);

    }


    @Override
    public ParentDTO saveParent(ParentDTO parentDTO, String email){
        Centre centre= utilisateurRepository.findByEmail(email).getCentre();

        CentreDTO centreVaccinationDTO=centreVaccMapper.asCentreDTO(centre);
        //centreVaccinationDTO.getParentsDTO().add(parentDTO);

        parentDTO.setCentreVaccinationDTO(centreVaccinationDTO);

        Parent parent=parentMapper.fromParentDTO(parentDTO);


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
    public ParentDTO saveParent(ParentDTO parentDTO, Long centreId)  {
       Centre centre= centreRepository.findById(centreId).
                orElseThrow(null);

       CentreVaccinationDTO centreVaccinationDTO=centreVaccMapper.fromCentreVaccination(centre);
       parentDTO.setCentreVaccinationDTO(centreVaccinationDTO);


      Parent parent= parentMapper.fromParentDTO(parentDTO);


      Parent parent1=parentRepository.save(parent);

        return parentMapper.fromParent(parent1);
    }
}
