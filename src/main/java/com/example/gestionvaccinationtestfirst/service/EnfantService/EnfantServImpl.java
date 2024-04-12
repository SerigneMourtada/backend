package com.example.gestionvaccinationtestfirst.service.EnfantService;

import com.example.gestionvaccinationtestfirst.DTos.EnfantDTO;
import com.example.gestionvaccinationtestfirst.DTos.ParentDTO;
import com.example.gestionvaccinationtestfirst.Excepyion.EnfantNotFoundException;
import com.example.gestionvaccinationtestfirst.Excepyion.ParentNotFoundException;
import com.example.gestionvaccinationtestfirst.dtoMapper.enfantMapper.EnfantMapper;
import com.example.gestionvaccinationtestfirst.dtoMapper.parentMapper.ParentMapper;
import com.example.gestionvaccinationtestfirst.model.Enfant;
import com.example.gestionvaccinationtestfirst.model.Parent;
import com.example.gestionvaccinationtestfirst.repository.EnfantRepository;
import com.example.gestionvaccinationtestfirst.repository.ParentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
@AllArgsConstructor
@Slf4j
public class EnfantServImpl implements EnfantServ{
    private EnfantRepository enfantRepository;

    private EnfantMapper enfantMapper;

    private ParentRepository parentRepository;

    private ParentMapper parentMapper;


    @Override
    public List<EnfantDTO> getAllEnfants() {
        List<Enfant> enfantList=enfantRepository.findAll();
        List<EnfantDTO> enfantDTOList=enfantList.stream().
                map(enfant -> enfantMapper.fromEnfant(enfant)).toList();
        return enfantDTOList;
    }

    @Override
    public EnfantDTO getEnfantById(Long enfantId) throws EnfantNotFoundException {
        Enfant enfant=enfantRepository.findById(enfantId)
                .orElseThrow(()->new EnfantNotFoundException("Enfant Not Found"));

        return enfantMapper.fromEnfant(enfant) ;
    }

    @Override
    public void deleteEnfant(Long enfantId){
        enfantRepository.deleteById(enfantId);

    }


    @Override
    public EnfantDTO updateEnfant(EnfantDTO enfantDTO){
        Enfant enfant=enfantMapper.fromEnfantDTO(enfantDTO);
        Enfant enfant1=enfantRepository.save(enfant);
        return enfantMapper.fromEnfant(enfant1);
    }

    @Override
    public EnfantDTO saveEnfant(EnfantDTO enfantDTO,String nom,String prenom,String telephone,String addresse,String lien){
        ParentDTO parentDTO=saveParent(nom,prenom,telephone,addresse,lien);
        parentDTO.setNom(nom);
        parentDTO.setPrenom(prenom);
        parentDTO.setTelephone(telephone);
        parentDTO.setLienDeParente(lien);
        enfantDTO.setParentDTO(parentDTO);
        Enfant enfant=enfantMapper.fromEnfantDTO(enfantDTO);
        Enfant enfant1=enfantRepository.save(enfant);
        return enfantMapper.fromEnfant(enfant1);
    }

    public ParentDTO saveParent(String nom,String prenom,String telephone,String addresse,String lien){
        Parent parent=new Parent();
        parent.setNom(nom);
        parent.setPrenom(prenom);
        parent.setTelephone(telephone);
        parent.setLienDeParente((lien));
        parent.setAddresse(addresse);
        Parent parent1=parentRepository.save(parent);
        return parentMapper.fromParent(parent1);
    }

    public EnfantDTO saveEnfant(EnfantDTO enfantDTO,Long parentId) throws ParentNotFoundException{
        Parent parent=parentRepository.findById(parentId)
                .orElseThrow(()->new ParentNotFoundException("Parent Id does not found"));
        ParentDTO parentDTO=parentMapper.fromParent(parent);

        enfantDTO.setParentDTO(parentDTO);
        Enfant enfant=enfantMapper.fromEnfantDTO(enfantDTO);
        parent.getEnfants().add(enfant);
        Enfant enfant1=enfantRepository.save(enfant);
        return enfantMapper.fromEnfant(enfant1);
    }
}
